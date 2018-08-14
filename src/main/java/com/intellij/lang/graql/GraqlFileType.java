package com.intellij.lang.graql;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author github.com/BFergerson
 */
public class GraqlFileType extends LanguageFileType {

    public static final GraqlFileType INSTANCE = new GraqlFileType();

    private GraqlFileType() {
        super(GraqlLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Graql";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Graql file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "gql";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return IconLoader.getIcon("/icons/grakn.png");
    }

}
