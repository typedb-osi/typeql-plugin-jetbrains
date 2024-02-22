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

    override fun getNode(): CompositeElement = super.getNode() as CompositeElement

    override fun getName(): String? { // TODO: Refactor
        return when (this) {
            is PsiTypeQLRelatesType -> this.scopedName
            else -> super.getName()
        }
    }

    open val scopedName: String?
        get() = name

    override fun toString(): String = String.format(
        "%s(%s) - Location: %s",
        javaClass.simpleName, node.elementType, textRange
    )
}
