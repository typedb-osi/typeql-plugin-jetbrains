package com.intellij.lang.graql.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

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
                        resultSet.addElement(LookupElementBuilder.create("id"));
                        resultSet.addElement(LookupElementBuilder.create("sub"));
                        resultSet.addElement(LookupElementBuilder.create("key"));
                        resultSet.addElement(LookupElementBuilder.create("has"));
                        resultSet.addElement(LookupElementBuilder.create("plays"));
                        resultSet.addElement(LookupElementBuilder.create("relates"));
                        resultSet.addElement(LookupElementBuilder.create("role"));
                        resultSet.addElement(LookupElementBuilder.create("relationship"));
                        resultSet.addElement(LookupElementBuilder.create("entity"));
                        resultSet.addElement(LookupElementBuilder.create("attribute"));
                        resultSet.addElement(LookupElementBuilder.create("datatype"));
                        resultSet.addElement(LookupElementBuilder.create("long"));
                        resultSet.addElement(LookupElementBuilder.create("double"));
                        resultSet.addElement(LookupElementBuilder.create("string"));
                        resultSet.addElement(LookupElementBuilder.create("date"));
                        resultSet.addElement(LookupElementBuilder.create("boolean"));
                        resultSet.addElement(LookupElementBuilder.create("via"));
                        resultSet.addElement(LookupElementBuilder.create("isa"));
                        resultSet.addElement(LookupElementBuilder.create("commit"));
                        resultSet.addElement(LookupElementBuilder.create("define"));
                        resultSet.addElement(LookupElementBuilder.create("insert"));
                        resultSet.addElement(LookupElementBuilder.create("match"));
                        resultSet.addElement(LookupElementBuilder.create("rule"));
                        resultSet.addElement(LookupElementBuilder.create("when"));
                        resultSet.addElement(LookupElementBuilder.create("then"));
                        resultSet.addElement(LookupElementBuilder.create("get"));
                        resultSet.addElement(LookupElementBuilder.create("compute"));
                        resultSet.addElement(LookupElementBuilder.create("cluster"));
                        resultSet.addElement(LookupElementBuilder.create("in"));
                        resultSet.addElement(LookupElementBuilder.create("member"));
                        resultSet.addElement(LookupElementBuilder.create("label"));
                        resultSet.addElement(LookupElementBuilder.create("is-abstract"));
                        resultSet.addElement(LookupElementBuilder.create("as"));
                        resultSet.addElement(LookupElementBuilder.create("delete"));
                        resultSet.addElement(LookupElementBuilder.create("aggregate"));
                        resultSet.addElement(LookupElementBuilder.create("ask"));
                        resultSet.addElement(LookupElementBuilder.create("count"));
                        resultSet.addElement(LookupElementBuilder.create("sum"));
                        resultSet.addElement(LookupElementBuilder.create("max"));
                        resultSet.addElement(LookupElementBuilder.create("min"));
                        resultSet.addElement(LookupElementBuilder.create("mean"));
                        resultSet.addElement(LookupElementBuilder.create("median"));
                        resultSet.addElement(LookupElementBuilder.create("group"));
                        resultSet.addElement(LookupElementBuilder.create("of"));
                        resultSet.addElement(LookupElementBuilder.create("std"));
                    }
                }
        );
    }

}
