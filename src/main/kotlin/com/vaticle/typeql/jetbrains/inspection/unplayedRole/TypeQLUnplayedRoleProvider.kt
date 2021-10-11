package com.vaticle.typeql.jetbrains.inspection.unplayedRole

import com.intellij.codeInspection.InspectionToolProvider
import com.intellij.codeInspection.LocalInspectionTool

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class TypeQLUnplayedRoleProvider : InspectionToolProvider {
    override fun getInspectionClasses(): Array<out Class<out LocalInspectionTool>> {
        return arrayOf(TypeQLUnplayedRoleInspection::class.java)
    }
}
