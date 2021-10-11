package com.vaticle.typeql.jetbrains.psi.constraint

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.util.IncorrectOperationException
import com.vaticle.typeql.jetbrains.psi.PsiTypeQLNamedElement
import com.vaticle.typeql.jetbrains.psi.TypeQLPsiUtils

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class PsiTypeConstraint(node: ASTNode) : PsiTypeQLNamedElement(node) {
    override fun getNameIdentifier(): PsiElement? {
        //todo: seems wrong
        return node.firstChildNode.psi
    }

    @Throws(IncorrectOperationException::class)
    override fun setName(name: String): PsiElement {
        return TypeQLPsiUtils.setName(this, name)
    }
}