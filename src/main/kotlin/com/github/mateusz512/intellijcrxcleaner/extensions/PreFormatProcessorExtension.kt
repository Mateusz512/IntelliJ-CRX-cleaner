package com.github.mateusz512.intellijcrxcleaner.extensions

import com.github.mateusz512.intellijcrxcleaner.core.XmlTreeProcessor
import com.intellij.lang.ASTNode
import com.intellij.openapi.components.service
import com.intellij.openapi.util.TextRange
import com.intellij.psi.impl.source.codeStyle.PreFormatProcessor
import com.intellij.psi.xml.XmlDocument

class PreFormatProcessorExtension : PreFormatProcessor {

    private val xmlTreeProcessor = service<XmlTreeProcessor>()

    override fun process(element: ASTNode, range: TextRange): TextRange {
        val root = element.firstChildNode
        if (root is XmlDocument) {
            xmlTreeProcessor.process(root)
        }
        return range
    }

}