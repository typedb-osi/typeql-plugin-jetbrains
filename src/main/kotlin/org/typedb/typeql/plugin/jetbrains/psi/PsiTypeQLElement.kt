package org.typedb.typeql.plugin.jetbrains.psi

import com.intellij.lang.ASTNode
import com.intellij.psi.impl.source.tree.CompositeElement
import org.typedb.typeql.plugin.jetbrains.psi.constraint.PsiTypeQLOwnsType
import org.typedb.typeql.plugin.jetbrains.psi.constraint.PsiTypeQLPlaysType
import org.typedb.typeql.plugin.jetbrains.psi.constraint.PsiTypeQLRelatesType
import org.typedb.typeql.plugin.jetbrains.psi.constraint.PsiTypeQLSubType
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
sealed class PsiTypeQLElement(node: ASTNode) : ANTLRPsiNode(node) {
    open val scopedName: String?
        get() = name

    override fun getNode(): CompositeElement = super.getNode() as CompositeElement

    override fun toString(): String = String.format(
        "%s(%s) - Location: %s",
        javaClass.simpleName, node.elementType, textRange
    )
}
