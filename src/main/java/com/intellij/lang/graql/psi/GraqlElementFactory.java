package com.intellij.lang.graql.psi;

import com.intellij.lang.graql.GraqlFileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;

/**
 * @author github.com/BFergerson
 */
public class GraqlElementFactory {

    public static GraqlIdentifier createIdentifier(Project project, String name) {
        final GraqlFile file = createFile(project, name);
        return (GraqlIdentifier) file.getFirstChild().getChildren()[0].getChildren()[0].getChildren()[0];
    }

    private static GraqlFile createFile(Project project, String text) {
        String name = "dummy.gql";
        return (GraqlFile) PsiFileFactory.getInstance(project).
                createFileFromText(name, GraqlFileType.INSTANCE, "define " + text + " sub entity");
    }

}
