package org.typedb.typeql.plugin.jetbrains.psi.constraint

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.util.IncorrectOperationException
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLNamedElement
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLUtils

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class PsiTypeQLType(node: ASTNode) : PsiTypeQLNamedElement(node) {
    override fun getNameIdentifier(): PsiElement? {
        return node.firstChildNode?.psi
    }

    @Throws(IncorrectOperationException::class)
    override fun setName(name: String): PsiElement {
        return PsiTypeQLUtils.setName(this, name)
    }
}