package com.intellij.lang.graql.inspection.duplicateDeclaration;

import com.intellij.codeInspection.InspectionToolProvider;

/**
 * @author github.com/BFergerson
 */
public class GraqlDuplicateDeclarationProvider implements InspectionToolProvider {

    public Class[] getInspectionClasses() {
        return new Class[]{GraqlDuplicateDeclarationInspection.class};
    }

}
