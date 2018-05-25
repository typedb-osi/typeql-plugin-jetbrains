package com.intellij.lang.graql.inspection.invalidTypeUsage;

import com.intellij.codeInspection.InspectionToolProvider;

/**
 * @author github.com/BFergerson
 */
public class GraqlInvalidTypeUsageProvider implements InspectionToolProvider {

    public Class[] getInspectionClasses() {
        return new Class[]{GraqlInvalidTypeUsageInspection.class};
    }

}
