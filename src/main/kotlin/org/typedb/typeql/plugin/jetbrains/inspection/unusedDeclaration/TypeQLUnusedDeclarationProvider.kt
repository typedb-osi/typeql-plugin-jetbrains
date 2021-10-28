package org.typedb.typeql.plugin.jetbrains.inspection.unusedDeclaration

import com.intellij.codeInspection.InspectionToolProvider
import com.intellij.codeInspection.LocalInspectionTool

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class TypeQLUnusedDeclarationProvider : InspectionToolProvider {
    override fun getInspectionClasses(): Array<out Class<out LocalInspectionTool>> {
        return arrayOf(
            TypeQLUnusedAttributeDeclarationInspection::class.java,
            TypeQLUnusedRoleDeclarationInspection::class.java
        )
    }
}
