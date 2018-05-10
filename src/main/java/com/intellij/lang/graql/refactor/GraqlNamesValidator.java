package com.intellij.lang.graql.refactor;

import com.intellij.lang.graql.psi.GraqlTokenTypeSets;
import com.intellij.lang.refactoring.NamesValidator;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * @author github.com/BFergerson
 */
public class GraqlNamesValidator implements NamesValidator {

    @Override
    public boolean isKeyword(@NotNull final String name, final Project project) {
        return GraqlTokenTypeSets.FULL_KEYWORD_SET.contains(name);
    }

    @Override
    public boolean isIdentifier(@NotNull final String name, final Project project) {
        return !GraqlTokenTypeSets.FULL_KEYWORD_SET.contains(name);
    }

}
