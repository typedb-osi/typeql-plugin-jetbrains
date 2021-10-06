package com.vaticle.typeql.jetbrains.inspection.unusedDeclaration

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.vaticle.typeql.jetbrains.psi.TypeQLPsiUtils
import com.vaticle.typeql.jetbrains.psi.statement.PsiStatementType
import org.apache.commons.lang.StringUtils

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class TypeQLUnusedRoleDeclarationInspection : LocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {
            override fun visitElement(element: PsiElement) {
                if (element is PsiStatementType) {
                    TypeQLPsiUtils.ensureTypeQLElementsUpToDate(element.getContainingFile())
                    for (declaration in element.findRelatesTypeProperties()) {
                        if (StringUtils.isEmpty(declaration.name)) {
                            return  //user still typing
                        }
                        val type = TypeQLPsiUtils.determineDeclarationType(declaration)
                        if ("role" == type) {
                            val usages = TypeQLPsiUtils.findUsages(declaration)
                            if (usages.isEmpty()) {
//                                if (declaration is PsiTypeConstraint) {
//                                    holder.registerProblem(
//                                        declaration.getFirstChild(),
//                                        "Role <code>#ref</code> is never used"
//                                    )
//                                } else {
                                holder.registerProblem(
                                    declaration.firstChild.nextSibling.nextSibling,
                                    "Role <code>#ref</code> is never used"
                                )
//                                }
                            }
                        }
                    }
                }
            }
        }
    }

    override fun getDisplayName(): String {
        return "Unused role declaration"
    }

    override fun getGroupDisplayName(): String {
        return "TypeQL"
    }

    override fun getShortName(): String {
        return "UnusedRoleDeclaration"
    }

    override fun isEnabledByDefault(): Boolean {
        return true
    }
}
