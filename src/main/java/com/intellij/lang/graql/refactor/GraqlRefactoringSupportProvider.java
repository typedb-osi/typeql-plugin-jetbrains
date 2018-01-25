package com.intellij.lang.graql.refactor;

import com.intellij.lang.graql.psi.GraqlIdentifierExpr;
import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;

/**
 * @author github.com/BFergerson
 */
public class GraqlRefactoringSupportProvider extends RefactoringSupportProvider {

    @Override
    public boolean isMemberInplaceRenameAvailable(PsiElement element, PsiElement context) {
        return element instanceof GraqlIdentifierExpr;
    }

}