package org.typedb.typeql.plugin.jetbrains

import com.google.common.collect.ImmutableSet
import com.intellij.lang.Language

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class TypeQLLanguage : Language(TypeQLFileType.LANG_NAME) {
    companion object {
        val INSTANCE: TypeQLLanguage = TypeQLLanguage()

        // TODO: Move to ParserDefinition and connect with the Parser's tokens
        val TYPEQL_TYPES: Set<String?> = ImmutableSet.of(
            "attribute",
            "entity",
            "relation",
            "rule",
            "role",
            "thing"
        )
    }
}
