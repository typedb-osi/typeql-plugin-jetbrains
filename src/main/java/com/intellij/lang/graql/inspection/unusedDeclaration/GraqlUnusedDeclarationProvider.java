package com.intellij.lang.graql.inspection.unusedDeclaration;

import com.intellij.codeInspection.InspectionToolProvider;

/**
 * @author github.com/BFergerson
 */
public class GraqlUnusedDeclarationProvider implements InspectionToolProvider {

    public Class[] getInspectionClasses() {
        return new Class[]{
                GraqlUnusedAttributeDeclarationInspection.class,
                GraqlUnusedRoleDeclarationInspection.class
        };
    }

}
