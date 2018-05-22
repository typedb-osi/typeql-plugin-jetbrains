package com.intellij.lang.graql.inspection.unplayedRole;

import com.intellij.codeInspection.InspectionToolProvider;

/**
 * @author github.com/BFergerson
 */
public class GraqlUnplayedRoleProvider implements InspectionToolProvider {

    public Class[] getInspectionClasses() {
        return new Class[]{GraqlUnplayedRoleInspection.class};
    }

}
