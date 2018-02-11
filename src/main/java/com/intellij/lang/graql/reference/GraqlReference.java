package com.intellij.lang.graql.reference;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.lang.graql.GraqlFileType;
import com.intellij.lang.graql.psi.GraqlIdentifier;
import com.intellij.lang.graql.psi.impl.GraqlPsiImplUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        final List<GraqlIdentifier> properties = GraqlPsiImplUtil.findIdentifiers(project, identifier);
        List<ResolveResult> results = new ArrayList<>();
        for (GraqlIdentifier property : properties) {
            results.add(new PsiElementResolveResult(property));
        }
        return results.toArray(new ResolveResult[results.size()]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length > 0 ? resolveResults[0].getElement() : null;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        Project project = myElement.getProject();
        List<LookupElement> variants = new ArrayList<>();
        List<GraqlIdentifier> identifiers = GraqlPsiImplUtil.findIdentifiers(project);
        Set<String> distinctVariants = new HashSet<>();

        for (GraqlIdentifier identifier : identifiers) {
            if (!distinctVariants.contains(identifier.getText())) {
                distinctVariants.add(identifier.getText());
                variants.add(LookupElementBuilder.create(identifier).
                        withIcon(GraqlFileType.INSTANCE.getIcon()).
                        withTypeText("entity|relationship|role|attribute") //todo: more specific
                );
            }
        }
        return variants.toArray();
    }

}
