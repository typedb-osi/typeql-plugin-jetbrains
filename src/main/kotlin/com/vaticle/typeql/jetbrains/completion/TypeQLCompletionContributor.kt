package com.vaticle.typeql.jetbrains.completion

import com.google.common.collect.ImmutableSet
import com.google.common.collect.Sets
import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.ide.scratch.ScratchUtil
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.ProcessingContext
import com.vaticle.typeql.jetbrains.TypeQLFileType
import com.vaticle.typeql.jetbrains.TypeQLLanguage
import com.vaticle.typeql.jetbrains.TypeQLParser
import com.vaticle.typeql.jetbrains.TypeQLParserDefinition
import com.vaticle.typeql.jetbrains.psi.TypeQLPsiUtils
import com.vaticle.typeql.jetbrains.psi.constraint.PsiOwnsTypeConstraint
import com.vaticle.typeql.jetbrains.psi.constraint.PsiPlaysTypeConstraint
import com.vaticle.typeql.jetbrains.psi.constraint.PsiRelatesTypeConstraint
import com.vaticle.typeql.jetbrains.psi.constraint.PsiSubTypeConstraint
import org.antlr.intellij.adaptor.parser.SyntaxError
import org.antlr.v4.runtime.misc.IntervalSet
import org.jetbrains.annotations.NonNls
import java.util.function.Consumer
import java.util.stream.Collectors

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class TypeQLCompletionContributor : CompletionContributor() {
    init {
        extend(
            CompletionType.BASIC, PlatformPatterns.psiElement(),
            object : CompletionProvider<CompletionParameters>() {
                public override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    resultSet: CompletionResultSet
                ) {
                    var includeKeywords = true
                    val ruleType = TypeQLPsiUtils.findParentByType(
                        parameters.position,
                        TypeQLParserDefinition.RULE_ELEMENT_TYPES[TypeQLParser.RULE_type_constraint]
                    )
                    if (ruleType != null) {
                        if (ruleType is PsiOwnsTypeConstraint) {
                            //owns, include all attributes
                            val statementType = TypeQLPsiUtils.findParentByType(
                                parameters.position,
                                TypeQLParserDefinition.RULE_ELEMENT_TYPES[TypeQLParser.RULE_variable_type]
                            )
                            includeAttributeTypes(
                                resultSet, ruleType, parameters.originalFile.virtualFile,
                                statementType!!.name!!
                            )
                        } else if (ruleType is PsiSubTypeConstraint) {
                            //sub, include all declarations & base types
                            val statementType = TypeQLPsiUtils.findParentByType(
                                parameters.position,
                                TypeQLParserDefinition.RULE_ELEMENT_TYPES[TypeQLParser.RULE_variable_type]
                            )
                            includeAllTypes(
                                resultSet, ruleType, parameters.originalFile.virtualFile,
                                statementType!!.name!!
                            )
                            includeBaseTypes(resultSet)
                        } else if (ruleType is PsiRelatesTypeConstraint) {
                            //relates, include all plays (roles)
                            includePlayRoles(parameters, resultSet)
                        } else if (ruleType is PsiPlaysTypeConstraint) {
                            //plays, include all relates (roles)
                            includeRelateRoles(parameters, resultSet)
                        } else {
                            //add type property modifiers
                            TYPE_PROPERTY_MODIFIERS.forEach(Consumer { keyword: String? ->
                                resultSet.addElement(
                                    LookupElementBuilder.create(
                                        keyword!!
                                    )
                                        .withIcon(TypeQLFileType.INSTANCE.icon)
                                        .withTypeText(keyword)
                                        .withBoldness(true)
                                )
                            })
                        }

                        //if looking for TYPE_NAME_ don't include keywords
                        if (parameters.position is LeafPsiElement) {
                            if ((parameters.position as LeafPsiElement).elementType ===
                                TypeQLParserDefinition.TOKEN_ELEMENT_TYPES[TypeQLParser.LABEL_]
                            ) {
                                includeKeywords = false
                            }
                        }
                    }
                    if (includeKeywords) {
                        val tokenToErrorMap: Map<Int, SyntaxError> = TypeQLCompletionErrorListener.tokenToErrorMap
                        var syntaxError = tokenToErrorMap[parameters.offset]
                        if (syntaxError == null) {
                            val currentText = parameters.position.text
                            if (currentText.contains(DUMMY_IDENTIFIER)) {
                                //currently typing; suggest same as before typing started
                                syntaxError =
                                    tokenToErrorMap[parameters.offset - (currentText.length - DUMMY_IDENTIFIER.length)]
                            }
                        }
                        if (syntaxError != null && syntaxError.exception != null && syntaxError.exception.expectedTokens != null) {
                            getActualKeywords(syntaxError.exception.expectedTokens).forEach(
                                Consumer { keyword: String? ->
                                    resultSet.addElement(
                                        LookupElementBuilder.create(
                                            keyword!!
                                        )
                                            .withIcon(TypeQLFileType.INSTANCE.icon)
                                            .withTypeText(keyword)
                                            .withBoldness(true)
                                    )
                                })
                        } else {
                            //no errors or suggested keywords; fallback to query types
                            includeQueryTypes(resultSet)
                        }
                    }
                }
            }
        )
    }

    private fun includeAttributeTypes(
        resultSet: CompletionResultSet, ruleType: PsiElement,
        containingFile: VirtualFile, vararg excludedNames: String
    ) {
        val excludedNameSet: Set<String?> = Sets.newHashSet(*excludedNames)
        val searchScope: Collection<VirtualFile?>
        searchScope = if (ScratchUtil.isScratch(containingFile)) {
            listOf(containingFile)
        } else {
            FileTypeIndex.getFiles(
                TypeQLFileType.INSTANCE,
                GlobalSearchScope.allScope(ruleType.project)
            )
        }
        TypeQLPsiUtils.getDeclarationsByType(ruleType.project, searchScope, "attribute").stream()
            .filter { !excludedNameSet.contains(it.name) }
            .forEach {
                val declarationType = TypeQLPsiUtils.determineDeclarationType(it)
                resultSet.addElement(
                    LookupElementBuilder.create(it)
                        .withIcon(TypeQLFileType.INSTANCE.icon)
                        .withTypeText(declarationType ?: "unknown")
                        .withStrikeoutness(declarationType == null)
                )
            }
    }

    private fun includeAllTypes(
        resultSet: CompletionResultSet, ruleType: PsiElement,
        containingFile: VirtualFile, vararg excludedNames: String
    ) {
        val excludedNameSet: Set<String?> = Sets.newHashSet(*excludedNames)
        val searchScope: Collection<VirtualFile?>
        searchScope = if (ScratchUtil.isScratch(containingFile)) {
            listOf(containingFile)
        } else {
            FileTypeIndex.getFiles(
                TypeQLFileType.INSTANCE,
                GlobalSearchScope.allScope(ruleType.project)
            )
        }
        TypeQLPsiUtils.getAllDeclarations(ruleType.project, searchScope).stream()
            .filter { !excludedNameSet.contains(it.name) }
            .forEach {
                val declarationType = TypeQLPsiUtils.determineDeclarationType(it)
                if (declarationType != null) {
                    resultSet.addElement(
                        LookupElementBuilder.create(it)
                            .withIcon(TypeQLFileType.INSTANCE.icon)
                            .withTypeText(declarationType)
                    )
                }
            }
    }

    private fun includeBaseTypes(resultSet: CompletionResultSet) {
        TypeQLLanguage.GRAQL_TYPES.forEach(Consumer {
            resultSet.addElement(
                LookupElementBuilder.create(
                    it!!
                )
                    .withIcon(TypeQLFileType.INSTANCE.icon)
                    .withTypeText(it)
                    .withBoldness(true)
            )
        })
    }

    private fun includePlayRoles(parameters: CompletionParameters, resultSet: CompletionResultSet) {
        PsiTreeUtil.collectElementsOfType(parameters.originalFile, PsiPlaysTypeConstraint::class.java)
            .forEach(Consumer {
                resultSet.addElement(
                    LookupElementBuilder.create(it.playsType!!)
                        .withIcon(TypeQLFileType.INSTANCE.icon)
                        .withTypeText("role")
                )
            })
    }

    private fun includeRelateRoles(parameters: CompletionParameters, resultSet: CompletionResultSet) {
        PsiTreeUtil.collectElementsOfType(parameters.originalFile, PsiRelatesTypeConstraint::class.java)
            .forEach(Consumer {
                resultSet.addElement(
                    LookupElementBuilder.create(it.name!!)
                        .withIcon(TypeQLFileType.INSTANCE.icon)
                        .withTypeText("role")
                )
            })
    }

    private fun includeQueryTypes(resultSet: CompletionResultSet) {
        resultSet.addElement(
            LookupElementBuilder.create("define")
                .withIcon(TypeQLFileType.INSTANCE.icon)
                .withTypeText("define")
                .withBoldness(true)
        )
        resultSet.addElement(
            LookupElementBuilder.create("compute")
                .withIcon(TypeQLFileType.INSTANCE.icon)
                .withTypeText("compute")
                .withBoldness(true)
        )
        resultSet.addElement(
            LookupElementBuilder.create("insert")
                .withIcon(TypeQLFileType.INSTANCE.icon)
                .withTypeText("insert")
                .withBoldness(true)
        )
        resultSet.addElement(
            LookupElementBuilder.create("match")
                .withIcon(TypeQLFileType.INSTANCE.icon)
                .withTypeText("match")
                .withBoldness(true)
        )
        resultSet.addElement(
            LookupElementBuilder.create("undefine")
                .withIcon(TypeQLFileType.INSTANCE.icon)
                .withTypeText("undefine")
                .withBoldness(true)
        )
    }

    companion object {
        @NonNls
        val DUMMY_IDENTIFIER = "IntellijIdeaRulezzz"
        private val TYPE_PROPERTY_MODIFIERS: Set<String> =
            ImmutableSet.copyOf(arrayOf("abstract", "sub", "key", "owns", "plays", "relates"))

        private fun getActualKeywords(keywordSet: IntervalSet): List<String> {
            return keywordSet.toList().stream()
                .map {
                    TypeQLParserDefinition.TOKEN_ELEMENT_TYPES[it!!].toString().replace("'", "")
                }
                .map { s: String ->
                    when (s) {
                        "SUB_" -> return@map listOf("sub", "sub!")
                        "IDD_" -> return@map ArrayList<String>() //todo: return IDs found
                        "VAR_", "LABEL_", "TYPE_IMPLICIT_" -> return@map ArrayList<String>()
                    }
                    listOf(s)
                }
                .flatMap { obj: List<String> -> obj.stream() }
                .distinct().collect(Collectors.toList())
        }
    }
}
