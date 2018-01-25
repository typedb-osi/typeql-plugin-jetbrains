package com.intellij.lang.graql.reference;

import com.intellij.lang.graql.psi.GraqlIdentifierExpr;
import com.intellij.lang.graql.psi.GraqlTokenTypes;
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
                GraqlTokenTypes.IDENTIFIER_EXPR), new PsiReferenceProvider() {
            @NotNull
            @Override
            public PsiReference[] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
                GraqlIdentifierExpr identifierExpr = (GraqlIdentifierExpr) element;
                String text;
                if (identifierExpr.getIdentifier() != null) {
                    text = identifierExpr.getIdentifier().getText();
                } else if (identifierExpr.getStringLiteral() != null) {
                    text = identifierExpr.getStringLiteral().getText();
                } else {
                    throw new UnsupportedOperationException("Invalid type: " + element);
                }
                return new PsiReference[]{new GraqlReference(identifierExpr, new TextRange(0, text.length()), text)};
            }
        });
    }

}

