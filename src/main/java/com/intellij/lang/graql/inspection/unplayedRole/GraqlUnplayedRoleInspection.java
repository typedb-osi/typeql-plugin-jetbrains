package com.intellij.lang.graql.inspection.unplayedRole;

import com.intellij.codeInspection.LocalInspectionTool;
import com.intellij.codeInspection.ProblemDescriptor;
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
public class GraqlUnplayedRoleInspection extends LocalInspectionTool {

    @NotNull
    @Override
    public PsiElementVisitor buildVisitor(@NotNull final ProblemsHolder holder, boolean isOnTheFly) {
        return new GraqlVisitor() {

            @Override
            public void visitIdentifier(@NotNull GraqlIdentifier identifier) {
                GraqlIdentifier declaration = GraqlPsiImplUtil.findDeclaration(
                        identifier.getProject(), identifier.getText());
                if (declaration != null) {
                    String type = GraqlPsiImplUtil.determineDeclarationType(declaration);
                    if ("role".equals(type)) {
                        boolean isPlayed = false;
                        List<GraqlIdentifier> usages = GraqlPsiImplUtil.findUsages(
                                identifier.getProject(), identifier.getText());
                        for (GraqlIdentifier usage : usages) {
                            String usageType = GraqlPsiImplUtil.determineUsageType(usage);
                            if ("plays".equals(usageType)) {
                                isPlayed = true;
                                break;
                            }
                        }

                        if (!isPlayed) {
                            boolean problemAlreadyRegistered = false;
                            for (ProblemDescriptor problem : holder.getResults()) {
                                if (problem.getPsiElement() == declaration
                                        && getDescriptionTemplate().equals(problem.getDescriptionTemplate())) {
                                    problemAlreadyRegistered = true;
                                    break;
                                }
                            }

                            if (!problemAlreadyRegistered) {
                                holder.registerProblem(declaration, getDescriptionTemplate());
                            }
                        }
                    }
                }
            }
        };
    }

    @NotNull
    private String getDescriptionTemplate() {
        return "Role <code>#ref</code> is never played";
    }

    @NotNull
    public String getDisplayName() {
        return "Unplayed role";
    }

    @NotNull
    public String getGroupDisplayName() {
        return "Graql";
    }

    @NotNull
    public String getShortName() {
        return "UnplayedRole";
    }

    @Override
    public boolean isEnabledByDefault() {
        return true;
    }

}
