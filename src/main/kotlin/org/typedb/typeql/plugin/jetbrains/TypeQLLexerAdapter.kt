package org.typedb.typeql.plugin.jetbrains

import com.intellij.lexer.FlexAdapter

class TypeQLLexerAdapter : FlexAdapter(TypeQLLexer(null))
