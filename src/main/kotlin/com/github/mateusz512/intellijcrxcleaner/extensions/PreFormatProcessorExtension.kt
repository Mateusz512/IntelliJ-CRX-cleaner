package com.github.mateusz512.intellijcrxcleaner.extensions

import com.github.mateusz512.intellijcrxcleaner.configuration.ConfigurationProvider
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.impl.source.codeStyle.PreFormatProcessor
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.xml.XmlAttribute
import com.intellij.psi.xml.XmlDocument
import com.intellij.psi.xml.XmlTag

class PreFormatProcessorExtension: PreFormatProcessor {

    override fun process(element: ASTNode, range: TextRange): TextRange {
        val root = element.firstChildNode
        if (root is XmlDocument) {
            val xmlTags = PsiTreeUtil.collectElementsOfType(root, XmlTag::class.java)
            xmlTags.forEach { xmlTag ->
                PsiTreeUtil.collectElementsOfType(xmlTag, XmlAttribute::class.java)
                    .filterNotNull()
                    .filter {
                        ConfigurationProvider.getObsoleteAttributes()
                            .any { regex -> regex.matches(it.name) }
                    }
                    .forEach(XmlAttribute::delete)
            }
        }
        return range
    }
}