package org.typedb.typeql.plugin.jetbrains.completion

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
import com.vaticle.typeql.grammar.TypeQLParser
import org.antlr.intellij.adaptor.parser.SyntaxError
import org.antlr.v4.runtime.misc.IntervalSet
import org.jetbrains.annotations.NonNls
import org.typedb.typeql.plugin.jetbrains.TypeQLFileType
import org.typedb.typeql.plugin.jetbrains.TypeQLLanguage
import org.typedb.typeql.plugin.jetbrains.TypeQLParserDefinition
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLUtils
import org.typedb.typeql.plugin.jetbrains.psi.constraint.PsiTypeQLOwnsType
import org.typedb.typeql.plugin.jetbrains.psi.constraint.PsiTypeQLPlaysType
import org.typedb.typeql.plugin.jetbrains.psi.constraint.PsiTypeQLRelatesType
import org.typedb.typeql.plugin.jetbrains.psi.constraint.PsiTypeQLSubType
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
                    val ruleType = PsiTypeQLUtils.findParentByType(
                        parameters.position,
                        TypeQLParserDefinition.getRule(TypeQLParser.RULE_type_constraint)!!
                    )
                    if (ruleType != null) {
                        if (ruleType is PsiTypeQLOwnsType) {
                            //owns, include all attributes
                            val statementType = PsiTypeQLUtils.findParentByType(
                                parameters.position,
                                TypeQLParserDefinition.getRule(TypeQLParser.RULE_statement_type)!!
                            )
                            includeAttributeTypes(
                                resultSet, ruleType, parameters.originalFile.virtualFile,
                                statementType!!.name!!
                            )
                        } else if (ruleType is PsiTypeQLSubType) {
                            //sub, include all declarations & base types
                            val statementType = PsiTypeQLUtils.findParentByType(
                                parameters.position,
                                TypeQLParserDefinition.getRule(TypeQLParser.RULE_statement_type)!!
                            )
                            includeAllTypes(
                                resultSet, ruleType, parameters.originalFile.virtualFile,
                                statementType!!.name!!
                            )
                            includeBaseTypes(resultSet)
                        } else if (ruleType is PsiTypeQLRelatesType) {
                            //relates, include all plays (roles)
                            includePlayRoles(parameters, resultSet)
                        } else if (ruleType is PsiTypeQLPlaysType) {
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
                                TypeQLParserDefinition.getToken(TypeQLParser.LABEL_)
                            ) {
                                includeKeywords = false
                            }
                        }
                    }

                    if (includeKeywords) {
                        includeQueryTypes(resultSet)
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
        val searchScope: Collection<VirtualFile?> = if (ScratchUtil.isScratch(containingFile)) {
            listOf(containingFile)
        } else {
            FileTypeIndex.getFiles(
                TypeQLFileType.INSTANCE,
                GlobalSearchScope.allScope(ruleType.project)
            )
        }

        PsiTypeQLUtils.getDeclarationsByType(ruleType.project, searchScope, "attribute").stream()
            .filter { !excludedNameSet.contains(it.name) }
            .forEach {
                val declarationType = PsiTypeQLUtils.determineDeclarationType(it)
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
        val searchScope: Collection<VirtualFile?> = if (ScratchUtil.isScratch(containingFile)) {
            listOf(containingFile)
        } else {
            FileTypeIndex.getFiles(
                TypeQLFileType.INSTANCE,
                GlobalSearchScope.allScope(ruleType.project)
            )
        }

        PsiTypeQLUtils.getAllDeclarations(ruleType.project, searchScope).stream()
            .filter { !excludedNameSet.contains(it.name) }
            .forEach {
                val declarationType = PsiTypeQLUtils.determineDeclarationType(it)
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
        TypeQLLanguage.TYPEQL_TYPES.forEach(Consumer {
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
        PsiTreeUtil.collectElementsOfType(parameters.originalFile, PsiTypeQLPlaysType::class.java)
            .forEach(Consumer {
                resultSet.addElement(
                    LookupElementBuilder.create(it.playsType!!)
                        .withIcon(TypeQLFileType.INSTANCE.icon)
                        .withTypeText("role")
                )
            })
    }

    private fun includeRelateRoles(parameters: CompletionParameters, resultSet: CompletionResultSet) {
        PsiTreeUtil.collectElementsOfType(parameters.originalFile, PsiTypeQLRelatesType::class.java)
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
                    TypeQLParserDefinition.getTokenText(it!!).replace("'", "")
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
