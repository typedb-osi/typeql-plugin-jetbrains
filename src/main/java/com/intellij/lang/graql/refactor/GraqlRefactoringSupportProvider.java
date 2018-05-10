package com.intellij.lang.graql.refactor;

import com.intellij.lang.graql.psi.GraqlIdentifier;
import com.intellij.lang.graql.psi.GraqlTokenTypeSets;
import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

/**
 * @author github.com/BFergerson
 */
public class GraqlRefactoringSupportProvider extends RefactoringSupportProvider {

    @Override
    public boolean isAvailable(@NotNull PsiElement context) {
        if (GraqlTokenTypeSets.FULL_KEYWORD_SET.contains(context.getText())) {
            return false;
        } else {
            return context instanceof GraqlIdentifier;
        }
    }

    @Override
    public boolean isMemberInplaceRenameAvailable(@NotNull PsiElement element, PsiElement context) {
        if (GraqlTokenTypeSets.FULL_KEYWORD_SET.contains(element.getText())) {
            return false;
        } else {
            return element instanceof GraqlIdentifier;
        }
    }

}