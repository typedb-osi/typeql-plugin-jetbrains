package com.vaticle.typeql.jetbrains.inspection.unusedDeclaration

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.vaticle.typeql.jetbrains.psi.TypeQLPsiUtils
import com.vaticle.typeql.jetbrains.psi.statement.PsiStatementType

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class TypeQLUnusedAttributeDeclarationInspection : LocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {
            override fun visitElement(element: PsiElement) {
                if (element is PsiStatementType) {
                    TypeQLPsiUtils.ensureTypeQLElementsUpToDate(element.getContainingFile())
                    for (declaration in element.findTypeProperties()) {
                        val type = TypeQLPsiUtils.determineDeclarationType(declaration!!)
                        if ("attribute" == type) {
                            val usages = TypeQLPsiUtils.findUsages(declaration)
                            if (usages.isEmpty()) {
                                holder.registerProblem(declaration, "Attribute <code>#ref</code> is never used")
                            }
                        }
                    }
                }
            }
        }
    }

    override fun getDisplayName(): String {
        return "Unused attribute declaration"
    }

    override fun getGroupDisplayName(): String {
        return "TypeQL"
    }

    override fun getShortName(): String {
        return "UnusedAttributeDeclaration"
    }

    override fun isEnabledByDefault(): Boolean {
        return true
    }
}