package org.typedb.typeql.plugin.jetbrains.refactor

import com.intellij.lang.refactoring.NamesValidator
import com.intellij.openapi.project.Project
import com.vaticle.typeql.grammar.TypeQLParser
import java.util.*

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
//class TypeQLNamesValidator : NamesValidator {
//    override fun isKeyword(name: String, project: Project): Boolean {
//        return TYPEQL_KEYWORDS.contains("'$name'")
//    }
//
//    override fun isIdentifier(name: String, project: Project): Boolean {
//        return !isKeyword(name, project)
//    }
//
//    companion object {
//        // TODO: filter for real keywords ("VAR_" isn't keyword)
//        val TYPEQL_KEYWORDS: Set<String> = HashSet(Arrays.asList(*TypeQLParser.tokenNames))
//    }
//}
