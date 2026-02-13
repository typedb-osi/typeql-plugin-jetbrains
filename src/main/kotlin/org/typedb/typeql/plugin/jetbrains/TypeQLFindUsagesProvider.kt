package org.typedb.typeql.plugin.jetbrains

import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLDefinitionFunction
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLDefinitionStruct
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLNamedElement
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLTypeDefinition
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLVar

class TypeQLFindUsagesProvider : FindUsagesProvider {

    override fun getWordsScanner(): WordsScanner {
        return DefaultWordsScanner(
            TypeQLLexerAdapter(),
            TypeQLTokenSets.IDENTIFIERS,
            TypeQLTokenSets.COMMENTS,
            TypeQLTokenSets.STRINGS
        )
    }

    override fun canFindUsagesFor(element: PsiElement): Boolean = element is TypeQLNamedElement

    override fun getType(element: PsiElement): String = when (element) {
        is TypeQLTypeDefinition -> "type"
        is TypeQLDefinitionFunction -> "function"
        is TypeQLDefinitionStruct -> "struct"
        is TypeQLVar -> "variable"
        else -> ""
    }

    override fun getDescriptiveName(element: PsiElement): String =
        (element as? PsiNamedElement)?.name ?: ""

    override fun getNodeText(element: PsiElement, useFullName: Boolean): String =
        getDescriptiveName(element)

    override fun getHelpId(element: PsiElement): String? = null
}
