package com.vaticle.typeql.jetbrains

import com.google.common.collect.ImmutableSet
import com.intellij.lang.Language

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class TypeQLLanguage : Language("TypeQL") {
    companion object {
        val INSTANCE: TypeQLLanguage = TypeQLLanguage()
        val GRAQL_TYPES: Set<String?> = ImmutableSet.of("attribute", "entity", "relation", "rule")
    }
}