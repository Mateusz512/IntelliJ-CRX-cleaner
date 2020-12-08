package com.github.mateusz512.intellijcrxcleaner.core

import com.github.mateusz512.intellijcrxcleaner.configuration.ConfigurationProvider
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.xml.XmlAttribute
import com.intellij.psi.xml.XmlDocument
import com.intellij.psi.xml.XmlTag
import com.intellij.psi.xml.XmlToken

@Service
class XmlTreeProcessor {

    private val configurationProvider = service<ConfigurationProvider>()

    fun process(root: XmlDocument) {
        val xmlTags = PsiTreeUtil.collectElementsOfType(root, XmlTag::class.java)
        xmlTags.forEach(::processXmlTag)
    }

    private fun processXmlTag(xmlTag: XmlTag) {
        PsiTreeUtil.collectElementsOfType(xmlTag, XmlAttribute::class.java)
            .filterNotNull()
            .filter { attribute ->
                configurationProvider.obsoleteAttributes
                    .any { regex -> regex.matches(attribute.name) }
            }
            .forEach(::deleteXmlAttribute)
    }

    private fun deleteXmlAttribute(xmlAttribute: XmlAttribute) {
        xmlAttribute.nextSibling?.let { nextSibling ->
            if (nextSibling is XmlToken && nextSibling.text == ">") {
                generateSequence(xmlAttribute.prevSibling) { it.prevSibling }
                    .takeWhile { it is PsiWhiteSpace }
                    .forEach(PsiElement::delete)
            }
        }
        xmlAttribute.delete()
    }
}