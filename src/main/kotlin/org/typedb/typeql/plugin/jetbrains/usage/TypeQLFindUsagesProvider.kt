package org.typedb.typeql.plugin.jetbrains.usage

import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.TokenSet
import org.typedb.typeql.plugin.jetbrains.TypeQLLanguage
import com.vaticle.typeql.grammar.TypeQLLexer
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.typedb.typeql.plugin.jetbrains.TypeQLFileType
import org.typedb.typeql.plugin.jetbrains.TypeQLTokenSets
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLElement

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class TypeQLFindUsagesProvider : FindUsagesProvider {
    override fun getWordsScanner(): WordsScanner? {
        return DefaultWordsScanner(
            ANTLRLexerAdaptor(TypeQLLanguage.INSTANCE, TypeQLLexer(null)),
            TypeQLTokenSets.IDENTIFIERS,
            TypeQLTokenSets.COMMENTS,
            TokenSet.EMPTY
        )
    }

    override fun canFindUsagesFor(element: PsiElement): Boolean {
        return element is PsiTypeQLElement
    }

    override fun getHelpId(psiElement: PsiElement): String? {
        return null
    }

    override fun getType(element: PsiElement): String {
        return if (element is PsiTypeQLElement) {
//            val declarationType = TypeQLPsiUtils.determineDeclarationType(element)
//            if (declarationType != null) {
//                "${TypeQLFileType.LANG_NAME} $declarationType"
//            } else {
                println("Somebody assk my TYPE! ${element.text}!")
                "${TypeQLFileType.LANG_NAME} element"
//            }
        } else ""
    }

    override fun getDescriptiveName(element: PsiElement): String {
        if (element !is PsiTypeQLElement) {
            return ""
        }

        println("getDescriptiveName for ${element.text}: ${element.scopedName!!}!")
        return element.scopedName!!
    }

    override fun getNodeText(element: PsiElement, useFullName: Boolean): String {
        if (element !is PsiTypeQLElement) {
            return ""
        }
        println("GetNodeText for ${element.text}: ${element.name!!}!")
        return element.name!!
    }
}