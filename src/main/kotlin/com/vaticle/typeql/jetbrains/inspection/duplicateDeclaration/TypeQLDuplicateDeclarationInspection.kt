package com.vaticle.typeql.jetbrains.inspection.duplicateDeclaration

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.vaticle.typeql.jetbrains.psi.PsiTypeQLNamedElement
import com.vaticle.typeql.jetbrains.psi.TypeQLPsiUtils
import com.vaticle.typeql.jetbrains.psi.constraint.PsiRelatesTypeConstraint
import com.vaticle.typeql.jetbrains.psi.constraint.PsiTypeConstraint
import java.util.stream.Collectors

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class TypeQLDuplicateDeclarationInspection : LocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {
            override fun visitElement(identifier: PsiElement) {
                if (identifier is PsiTypeQLNamedElement) {
                    TypeQLPsiUtils.ensureTypeQLElementsUpToDate(identifier.getContainingFile())
                    val declarationTypes = TypeQLPsiUtils.findDeclarations(
                        identifier.getProject(), identifier
                    ).stream()
                        .map {
                            if (it is PsiRelatesTypeConstraint) "relation" else TypeQLPsiUtils.determineDeclarationType(
                                it
                            )
                        }
                        .distinct().collect(Collectors.toList())
                    if (declarationTypes.size > 1) {
                        if (identifier is PsiTypeConstraint) {
                            holder.registerProblem(
                                identifier.getFirstChild(),
                                "Concept <code>#ref</code> has been defined more than once",
                                ProblemHighlightType.GENERIC_ERROR
                            )
                        } else {
                            holder.registerProblem(
                                identifier.getFirstChild().nextSibling.nextSibling,
                                "Concept <code>#ref</code> has been defined more than once",
                                ProblemHighlightType.GENERIC_ERROR
                            )
                        }
                    }
                }
            }
        }
    }

    override fun getDisplayName(): String {
        return "Duplicate declaration"
    }

    override fun getGroupDisplayName(): String {
        return "TypeQL"
    }

    override fun getShortName(): String {
        return "DuplicateDeclaration"
    }

    override fun isEnabledByDefault(): Boolean {
        return true
    }
}