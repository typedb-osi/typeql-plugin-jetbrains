package org.typedb.typeql.plugin.jetbrains.psi

import com.intellij.lang.ASTNode
import com.intellij.psi.impl.source.tree.CompositeElement
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
sealed class PsiTypeQLElement(node: ASTNode) : ANTLRPsiNode(node) {
    open val labelNode: ASTNode?
        get() = node

    open val scopedName: String?
        get() = name

    open val tokenText = ""

    protected val tokenTextOffset
        get() = tokenText.length - 1 // Minus 2 quotes, plus 1 space

    override fun getNode(): CompositeElement = super.getNode() as CompositeElement

    override fun toString(): String = String.format(
        "%s(%s) - Location: %s",
        javaClass.simpleName, node.elementType, textRange
    )
}
