package com.intellij.lang.graql.reference;

import com.intellij.lang.graql.psi.GraqlIdentifier;
import com.intellij.lang.graql.psi.GraqlTokenTypes;
import com.intellij.lang.graql.psi.impl.GraqlPsiImplUtil;
import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

/**
 * @author github.com/BFergerson
 */
public class GraqlReferenceContributor extends PsiReferenceContributor {

    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(
                GraqlTokenTypes.IDENTIFIER), new PsiReferenceProvider() {
            @NotNull
            @Override
            public PsiReference[] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
                GraqlIdentifier identifierExpr = (GraqlIdentifier) element;
                String text = identifierExpr.getText();
                if (identifierExpr == GraqlPsiImplUtil.findDeclaration(identifierExpr.getProject(), identifierExpr.getText())) {
                    return new PsiReference[0];
                } else {
                    return new PsiReference[]{new GraqlReference(identifierExpr, new TextRange(0, text.length()), text)};
                }
            }
        });
    }

}

