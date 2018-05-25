package com.intellij.lang.graql.reference;

import com.intellij.lang.graql.psi.GraqlIdentifier;
import com.intellij.lang.graql.psi.impl.GraqlPsiImplUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author github.com/BFergerson
 */
public class GraqlReference extends PsiReferenceBase<GraqlIdentifier> implements PsiPolyVariantReference {

    private final String identifier;

    public GraqlReference(@NotNull GraqlIdentifier element, @NotNull TextRange textRange,
                          @NotNull String identifier) {
        super(element, textRange);
        this.identifier = identifier;
    }

    @NotNull
    @Override
    public PsiElement handleElementRename(String newElementName) throws IncorrectOperationException {
        GraqlPsiImplUtil.setName(myElement, newElementName);
        return myElement;
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        List<ResolveResult> results = new ArrayList<>();
        for (GraqlIdentifier identifier : GraqlPsiImplUtil.findUsages(project, identifier)) {
            results.add(new PsiElementResolveResult(identifier));
        }
        return results.toArray(new ResolveResult[0]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        return GraqlPsiImplUtil.findDeclaration(myElement.getProject(), identifier);
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return new Object[0];
    }

}
