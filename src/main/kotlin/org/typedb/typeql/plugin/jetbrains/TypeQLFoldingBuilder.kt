package org.typedb.typeql.plugin.jetbrains

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

class TypeQLFoldingBuilder : FoldingBuilderEx(), DumbAware {

    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean): Array<FoldingDescriptor> {
        val descriptors = mutableListOf<FoldingDescriptor>()
        val openBraces = mutableListOf<Int>()

        val text = root.text
        var i = 0
        while (i < text.length) {
            when (text[i]) {
                '{' -> openBraces.add(i)
                '}' -> {
                    if (openBraces.isNotEmpty()) {
                        val openOffset = openBraces.removeAt(openBraces.lastIndex)
                        val closeOffset = i
                        if (closeOffset > openOffset + 1) {
                            val range = TextRange(openOffset, closeOffset + 1)
                            val node = root.node
                            if (node != null) {
                                descriptors.add(FoldingDescriptor(node, range))
                            }
                        }
                    }
                }
                '"' -> {
                    // Skip string literals to avoid matching braces inside strings
                    i++
                    while (i < text.length && text[i] != '"') {
                        if (text[i] == '\\') i++ // skip escaped char
                        i++
                    }
                }
                '#' -> {
                    // Skip line comments
                    while (i < text.length && text[i] != '\n') i++
                }
            }
            i++
        }

        return descriptors.toTypedArray()
    }

    override fun getPlaceholderText(node: ASTNode): String = "{...}"

    override fun isCollapsedByDefault(node: ASTNode): Boolean = false
}
