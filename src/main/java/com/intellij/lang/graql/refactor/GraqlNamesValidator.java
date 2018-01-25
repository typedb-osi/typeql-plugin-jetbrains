package com.intellij.lang.graql.refactor;

import com.intellij.lang.refactoring.NamesValidator;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * @author github.com/BFergerson
 */
public class GraqlNamesValidator implements NamesValidator {

    @Override
    public boolean isKeyword(@NotNull final String name, final Project project) {
        return false;
    }

    @Override
    public boolean isIdentifier(@NotNull final String name, final Project project) {
        return true;
    }

}
