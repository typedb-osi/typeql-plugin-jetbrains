package com.intellij.lang.graql.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.lang.graql.GraqlFileType;
import com.intellij.lang.graql.psi.GraqlIdentifier;
import com.intellij.lang.graql.psi.GraqlTokenTypeSets;
import com.intellij.lang.graql.psi.impl.GraqlPsiImplUtil;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

/**
 * @author github.com/BFergerson
 */
public class GraqlCompletionContributor extends CompletionContributor {

    public GraqlCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters, ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        //todo: smarter?
                        //identifiers
                        Set<String> distinctIdentifiers = new HashSet<>();
                        GraqlPsiImplUtil.findIdentifiers(parameters.getEditor().getProject())
                                .forEach(identifier -> {
                                    if (!distinctIdentifiers.contains(identifier.getText())) {
                                        distinctIdentifiers.add(identifier.getText());
                                        GraqlIdentifier declaration = GraqlPsiImplUtil.findDeclaration(
                                                identifier.getProject(), identifier.getText());
                                        if (declaration != null) {
                                            resultSet.addElement(LookupElementBuilder.create(identifier).
                                                    withIcon(GraqlFileType.INSTANCE.getIcon()).
                                                    withTypeText(GraqlPsiImplUtil.determineDeclarationType(declaration))
                                            );
                                        } else {
                                            resultSet.addElement(LookupElementBuilder.create(identifier).
                                                    withIcon(GraqlFileType.INSTANCE.getIcon())
                                            );
                                        }
                                    }
                                });
                        //keywords
                        for (String keyword : GraqlTokenTypeSets.FULL_KEYWORD_SET) {
                            resultSet.addElement(LookupElementBuilder.create(keyword));
                        }
                    }
                }
        );
    }

}
