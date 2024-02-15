package org.typedb.typeql.plugin.jetbrains.usage

import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.TokenSet
import org.typedb.typeql.plugin.jetbrains.TypeQLLanguage
import com.vaticle.typeql.grammar.TypeQLLexer
import org.typedb.typeql.plugin.jetbrains.TypeQLParserDefinition
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLNamedElement
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLPsiUtils
import org.typedb.typeql.plugin.jetbrains.psi.constraint.PsiRelatesTypeConstraint
import org.typedb.typeql.plugin.jetbrains.psi.constraint.PsiSubTypeConstraint
import org.typedb.typeql.plugin.jetbrains.psi.constraint.PsiTypeConstraint
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class TypeQLFindUsagesProvider : FindUsagesProvider {
    override fun getWordsScanner(): WordsScanner? {
        val lexer = TypeQLLexer(null)
        return DefaultWordsScanner(
            ANTLRLexerAdaptor(TypeQLLanguage.INSTANCE, lexer),
            TypeQLParserDefinition.Companion.IDS,
            TypeQLParserDefinition.Companion.COMMENTS,
            TokenSet.EMPTY
        )
    }

    override fun canFindUsagesFor(psiElement: PsiElement): Boolean {
        return (psiElement is PsiTypeConstraint
                || psiElement is PsiSubTypeConstraint
                || psiElement is PsiRelatesTypeConstraint)
    }

    override fun getHelpId(psiElement: PsiElement): String? {
        return null
    }

    override fun getType(element: PsiElement): String {
        return if (element is PsiTypeQLNamedElement) {
            val declarationType = TypeQLPsiUtils.determineDeclarationType(element)
            if (declarationType != null) {
                "TypeQL $declarationType"
            } else {
                "TypeQL element"
            }
        } else {
            //todo: can this happen?
            ""
        }
    }

    override fun getDescriptiveName(element: PsiElement): String {
        return element.text
    }

    override fun getNodeText(element: PsiElement, useFullName: Boolean): String {
        val namedElement = element as PsiTypeQLNamedElement
        return namedElement.name!!
    }
}