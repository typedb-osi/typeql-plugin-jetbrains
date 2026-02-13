package org.typedb.typeql.plugin.jetbrains

import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLTypes

class TypeQLBraceMatcher : PairedBraceMatcher {

    companion object {
        private val PAIRS = arrayOf(
            BracePair(TypeQLTypes.LPAREN, TypeQLTypes.RPAREN, false),
            BracePair(TypeQLTypes.LBRACE, TypeQLTypes.RBRACE, true),
            BracePair(TypeQLTypes.LBRACKET, TypeQLTypes.RBRACKET, false),
        )
    }

    override fun getPairs(): Array<BracePair> = PAIRS

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, contextType: IElementType?): Boolean = true

    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int = openingBraceOffset
}
