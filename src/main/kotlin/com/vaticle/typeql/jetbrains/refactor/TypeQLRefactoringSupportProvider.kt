package com.vaticle.typeql.jetbrains.refactor

import com.intellij.lang.refactoring.RefactoringSupportProvider
import com.intellij.psi.PsiElement
import com.vaticle.typeql.jetbrains.psi.PsiTypeQLNamedElement

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class TypeQLRefactoringSupportProvider : RefactoringSupportProvider() {
    override fun isAvailable(context: PsiElement): Boolean {
        return context is PsiTypeQLNamedElement
    }

    override fun isMemberInplaceRenameAvailable(element: PsiElement, context: PsiElement?): Boolean {
        return element is PsiTypeQLNamedElement
    }
}