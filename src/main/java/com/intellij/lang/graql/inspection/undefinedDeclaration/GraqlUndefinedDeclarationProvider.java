package com.intellij.lang.graql.inspection.undefinedDeclaration;

import com.intellij.codeInspection.InspectionToolProvider;

/**
 * @author github.com/BFergerson
 */
public class GraqlUndefinedDeclarationProvider implements InspectionToolProvider {

    public Class[] getInspectionClasses() {
        return new Class[]{GraqlUndefinedDeclarationInspection.class};
    }

}
