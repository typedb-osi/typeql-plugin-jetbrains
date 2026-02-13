package org.typedb.typeql.plugin.jetbrains

import com.intellij.psi.tree.IElementType

class TypeQLTokenType(debugName: String) : IElementType(debugName, TypeQLLanguage) {
    override fun toString(): String = "TypeQLTokenType." + super.toString()
}
