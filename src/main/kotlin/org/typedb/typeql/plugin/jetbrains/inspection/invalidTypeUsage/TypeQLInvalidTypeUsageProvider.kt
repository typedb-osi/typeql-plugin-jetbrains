package org.typedb.typeql.plugin.jetbrains.inspection.invalidTypeUsage

import com.intellij.codeInspection.InspectionToolProvider
import com.intellij.codeInspection.LocalInspectionTool

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class TypeQLInvalidTypeUsageProvider : InspectionToolProvider {
    override fun getInspectionClasses(): Array<out Class<out LocalInspectionTool>> {
        return arrayOf(TypeQLInvalidTypeUsageInspection::class.java)
    }
}
