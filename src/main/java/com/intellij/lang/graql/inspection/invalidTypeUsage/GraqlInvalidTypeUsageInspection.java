package com.intellij.lang.graql.inspection.invalidTypeUsage;

import com.google.common.collect.Sets;
import com.intellij.codeInspection.LocalInspectionTool;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.lang.graql.psi.GraqlIdentifier;
import com.intellij.lang.graql.psi.GraqlVisitor;
import com.intellij.lang.graql.psi.impl.GraqlPsiImplUtil;
import com.intellij.psi.PsiElementVisitor;
import org.codehaus.plexus.util.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author github.com/BFergerson
 */
public class GraqlInvalidTypeUsageInspection extends LocalInspectionTool {

    private final Map<String, Set<String>> invalidTypeUsages;

    public GraqlInvalidTypeUsageInspection() {
        invalidTypeUsages = new HashMap<>();
        invalidTypeUsages.put("entity", Sets.newHashSet("relates", "plays"));
        invalidTypeUsages.put("role", Sets.newHashSet("has"));
        invalidTypeUsages.put("attribute", Sets.newHashSet("plays"));
        invalidTypeUsages.put("relationship", Sets.newHashSet("plays", "has"));
    }

    @NotNull
    @Override
    public PsiElementVisitor buildVisitor(@NotNull final ProblemsHolder holder, boolean isOnTheFly) {
        return new GraqlVisitor() {

            @Override
            public void visitIdentifier(@NotNull GraqlIdentifier identifier) {
                GraqlIdentifier declaration = GraqlPsiImplUtil.findDeclaration(identifier.getProject(), identifier.getText());
                if (declaration != null) {
                    String declarationType = GraqlPsiImplUtil.determineDeclarationType(declaration);
                    String usageType = GraqlPsiImplUtil.determineUsageType(identifier);
                    if (usageType != null && invalidTypeUsages.get(declarationType).contains(usageType)) {
                        holder.registerProblem(identifier, StringUtils.capitalise(declarationType) +
                                        " <code>#ref</code> cannot be used as type: " + usageType,
                                ProblemHighlightType.GENERIC_ERROR);
                    }
                }
            }
        };
    }

    @NotNull
    public String getDisplayName() {
        return "Invalid type usage";
    }

    @NotNull
    public String getGroupDisplayName() {
        return "Graql";
    }

    @NotNull
    public String getShortName() {
        return "InvalidTypeUsage";
    }

    @Override
    public boolean isEnabledByDefault() {
        return true;
    }

}
