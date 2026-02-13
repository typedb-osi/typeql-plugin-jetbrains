package org.typedb.typeql.plugin.jetbrains

import com.intellij.lang.Language

object TypeQLLanguage : Language("TypeQL") {
    private fun readResolve(): Any = TypeQLLanguage
}
