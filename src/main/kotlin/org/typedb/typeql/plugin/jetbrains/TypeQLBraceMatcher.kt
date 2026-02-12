package org.typedb.typeql.plugin.jetbrains

import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType

class TypeQLBraceMatcher : PairedBraceMatcher {

    companion object {
        private val PAIRS = arrayOf(
            BracePair(TypeQLTokenTypes.LPAREN, TypeQLTokenTypes.RPAREN, false),
            BracePair(TypeQLTokenTypes.LBRACE, TypeQLTokenTypes.RBRACE, true),
            BracePair(TypeQLTokenTypes.LBRACKET, TypeQLTokenTypes.RBRACKET, false),
        )
    }

    override fun getPairs(): Array<BracePair> = PAIRS

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, contextType: IElementType?): Boolean = true

    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int = openingBraceOffset
}
