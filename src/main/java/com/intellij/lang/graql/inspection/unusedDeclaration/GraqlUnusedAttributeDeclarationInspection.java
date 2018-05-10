package com.intellij.lang.graql.inspection.unusedDeclaration;

import com.intellij.codeInspection.LocalInspectionTool;
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
public class GraqlUnusedAttributeDeclarationInspection extends LocalInspectionTool {

    @NotNull
    @Override
    public PsiElementVisitor buildVisitor(@NotNull final ProblemsHolder holder, boolean isOnTheFly) {
        return new GraqlVisitor() {

            @Override
            public void visitIdentifier(@NotNull GraqlIdentifier identifier) {
                GraqlIdentifier declaration = GraqlPsiImplUtil.findDeclaration(identifier.getProject(), identifier.getText());
                if (declaration != null) {
                    String type = GraqlPsiImplUtil.determineDeclarationType(declaration);
                    if ("attribute".equals(type)) {
                        List<GraqlIdentifier> usages = GraqlPsiImplUtil.findUsages(identifier.getProject(), identifier.getText());
                        if (usages.isEmpty()) {
                            holder.registerProblem(identifier, "Attribute <code>#ref</code> is never used");
                        }
                    }
                }
            }
        };
    }

    @NotNull
    public String getDisplayName() {
        return "Unused attribute declaration";
    }

    @NotNull
    public String getGroupDisplayName() {
        return "Graql";
    }

    @NotNull
    public String getShortName() {
        return "UnusedAttributeDeclaration";
    }

    @Override
    public boolean isEnabledByDefault() {
        return true;
    }

}
