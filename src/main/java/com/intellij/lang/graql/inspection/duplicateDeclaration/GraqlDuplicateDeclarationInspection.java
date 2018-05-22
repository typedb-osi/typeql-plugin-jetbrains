package com.intellij.lang.graql.inspection.duplicateDeclaration;

import com.intellij.codeInspection.LocalInspectionTool;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.lang.graql.psi.GraqlIdentifier;
import com.intellij.lang.graql.psi.GraqlVisitor;
import com.intellij.lang.graql.psi.impl.GraqlPsiImplUtil;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author github.com/BFergerson
 */
public class GraqlDuplicateDeclarationInspection extends LocalInspectionTool {

    @NotNull
    @Override
    public PsiElementVisitor buildVisitor(@NotNull final ProblemsHolder holder, boolean isOnTheFly) {
        return new GraqlVisitor() {

            @Override
            public void visitIdentifier(@NotNull GraqlIdentifier identifier) {
                List<GraqlIdentifier> declarations = GraqlPsiImplUtil.findDeclarations(
                        identifier.getProject(), identifier.getText());
                if (!declarations.isEmpty() && declarations.size() > 1) {
                    holder.registerProblem(identifier,
                            "Concept <code>#ref</code> has been defined more than once",
                            ProblemHighlightType.GENERIC_ERROR);
                }
            }
        };
    }

    @NotNull
    public String getDisplayName() {
        return "Duplicate declaration";
    }

    @NotNull
    public String getGroupDisplayName() {
        return "Graql";
    }

    @NotNull
    public String getShortName() {
        return "DuplicateDeclaration";
    }

    @Override
    public boolean isEnabledByDefault() {
        return true;
    }

}
