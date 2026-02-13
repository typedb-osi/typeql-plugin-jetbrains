package org.typedb.typeql.plugin.jetbrains

import com.intellij.lang.refactoring.RefactoringSupportProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLNamedElement

class TypeQLRefactoringSupportProvider : RefactoringSupportProvider() {

    override fun isMemberInplaceRenameAvailable(element: PsiElement, context: PsiElement?): Boolean =
        element is TypeQLNamedElement

    override fun isInplaceRenameAvailable(element: PsiElement, context: PsiElement?): Boolean =
        element is PsiNameIdentifierOwner
}
