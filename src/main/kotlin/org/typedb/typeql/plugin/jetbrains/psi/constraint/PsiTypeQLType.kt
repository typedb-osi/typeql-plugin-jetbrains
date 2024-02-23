package org.typedb.typeql.plugin.jetbrains.psi.constraint

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.util.IncorrectOperationException
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLElementFactory
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLNamedElement
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLUtils

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class PsiTypeQLType(node: ASTNode) : PsiTypeQLNamedElement(node) {
    override val labelNode: ASTNode?
        get() = node.firstChildNode

    override fun getNameIdentifier(): PsiElement? {
        return labelNode?.psi
    }

    @Throws(IncorrectOperationException::class)
    override fun setName(name: String): PsiElement {
        val typeProperty = PsiTypeQLElementFactory.createTypeProperty(project, name)
        if (labelNode == null || typeProperty.labelNode == null) {
            throw NullPointerException("Can not access label node for $this")
        }

        node.replaceChild(labelNode!!, typeProperty.labelNode!!)
        return this
    }
}
