package com.intellij.lang.graql.inspection.undefinedDeclaration;

import com.intellij.codeInspection.LocalInspectionTool;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.lang.graql.psi.GraqlIdentifier;
import com.intellij.lang.graql.psi.GraqlTokenTypes;
import com.intellij.lang.graql.psi.GraqlVisitor;
import com.intellij.lang.graql.psi.impl.GraqlPsiImplUtil;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

/**
 * @author github.com/BFergerson
 */
public class GraqlUndefinedDeclarationInspection extends LocalInspectionTool {

    private final static Pattern GRAQL_TEMPLATE_ID = Pattern.compile("<.+>");

    @NotNull
    @Override
    public PsiElementVisitor buildVisitor(@NotNull final ProblemsHolder holder, boolean isOnTheFly) {
        return new GraqlVisitor() {

            @Override
            public void visitIdentifier(@NotNull GraqlIdentifier identifier) {
                GraqlIdentifier declaration = GraqlPsiImplUtil.findDeclaration(
                        identifier.getProject(), identifier.getText());
                if (declaration == null && identifier.getParent() != null) {
                    if (!GRAQL_TEMPLATE_ID.matcher(identifier.getParent().getText()).find()
                            && !GraqlPsiImplUtil.isIdIdentifier(identifier)) {
                        if (identifier.getFirstChild() != null &&
                                identifier.getFirstChild().getNode().getElementType()
                                        == GraqlTokenTypes.STRING_LITERAL) {
                            return; //ignore string literals
                        }

                        holder.registerProblem(identifier,
                                "Concept <code>#ref</code> has not been defined",
                                ProblemHighlightType.GENERIC_ERROR);
                    }
                }
            }
        };
    }

    @NotNull
    public String getDisplayName() {
        return "Undefined declaration";
    }

    @NotNull
    public String getGroupDisplayName() {
        return "Graql";
    }

    @NotNull
    public String getShortName() {
        return "UndefinedDeclaration";
    }

    @Override
    public boolean isEnabledByDefault() {
        return true;
    }

}
