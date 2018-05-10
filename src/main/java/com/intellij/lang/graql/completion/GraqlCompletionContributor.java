package com.intellij.lang.graql.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.lang.graql.psi.GraqlIdentifier;
import com.intellij.lang.graql.psi.GraqlTokenTypeSets;
import com.intellij.lang.graql.psi.impl.GraqlPsiImplUtil;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author github.com/BFergerson
 */
public class GraqlCompletionContributor extends CompletionContributor {

    public GraqlCompletionContributor() {
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters, ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        //todo: smarter?
                        List<GraqlIdentifier> identifiers = GraqlPsiImplUtil.findIdentifiers(
                                parameters.getEditor().getProject());

                        //identifiers
                        for (GraqlIdentifier identifier : identifiers) {
                            resultSet.addElement(LookupElementBuilder.create(identifier.getText()));
                        }
                        //keywords
                        for (String keyword : GraqlTokenTypeSets.FULL_KEYWORD_SET) {
                            resultSet.addElement(LookupElementBuilder.create(keyword));
                        }
                    }
                }
        );
    }

}
