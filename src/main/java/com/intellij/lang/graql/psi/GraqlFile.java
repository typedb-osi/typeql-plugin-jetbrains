package com.intellij.lang.graql.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.lang.graql.GraqlFileType;
import com.intellij.lang.graql.GraqlLanguage;
import org.jetbrains.annotations.NotNull;

/**
 * @author github.com/BFergerson
 */
public class GraqlFile extends PsiFileBase {

    public GraqlFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, GraqlLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return GraqlFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Graql file";
    }

}