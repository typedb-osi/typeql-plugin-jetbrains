package com.vaticle.typeql.jetbrains.completion

import org.antlr.intellij.adaptor.parser.SyntaxError
import org.antlr.intellij.adaptor.parser.SyntaxErrorListener

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class TypeQLCompletionErrorListener : SyntaxErrorListener() {
    init {
        INSTANCE = this
    }

    companion object {
        private lateinit var INSTANCE: TypeQLCompletionErrorListener
        val tokenToErrorMap: Map<Int, SyntaxError>
            get() {
                val tokenToErrorMap: MutableMap<Int, SyntaxError> = HashMap()
                for (error in INSTANCE.syntaxErrors) {
                    tokenToErrorMap[error.offendingSymbol.startIndex] = error
                }
                return tokenToErrorMap
            }
    }
}