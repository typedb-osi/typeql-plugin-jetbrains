package com.vaticle.typeql.jetbrains.inspection.undefinedDeclaration

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiErrorElement
import com.vaticle.typeql.jetbrains.TypeQLLanguage
import com.vaticle.typeql.jetbrains.psi.PsiTypeQLElement
import com.vaticle.typeql.jetbrains.psi.TypeQLPsiUtils
import com.vaticle.typeql.jetbrains.psi.statement.PsiStatementType
import org.apache.commons.lang.StringUtils

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class TypeQLUndefinedDeclarationInspection : LocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {
            override fun visitElement(element: PsiElement) {
                if (element is PsiStatementType) {
                    TypeQLPsiUtils.ensureTypeQLElementsUpToDate(element.getContainingFile())
                    val identifiers: MutableList<PsiTypeQLElement?> = ArrayList()
                    identifiers.addAll(element.findOwnsTypeProperties())
                    identifiers.addAll(element.findPlaysTypeProperties())
                    identifiers.addAll(element.findSubTypeProperties())
                    for (identifier in identifiers) {
                        if (StringUtils.isEmpty(identifier!!.name)) {
                            return  //user still typing
                        }
                        val declaration = TypeQLPsiUtils.findDeclaration(
                            identifier.project, identifier
                        )
                        if (declaration == null) {
                            var undefinedConcept: PsiElement
                            undefinedConcept =
                                if (identifier.firstChild != null && identifier.firstChild.nextSibling != null && identifier.firstChild.nextSibling.nextSibling != null) {
                                    identifier.firstChild.nextSibling.nextSibling
                                } else {
                                    return  //user still typing
                                }
                            if (TypeQLLanguage.GRAQL_TYPES.contains(undefinedConcept.text)) {
                                return  //defined by language
                            }
                            if (undefinedConcept.firstChild !is PsiErrorElement) {
                                holder.registerProblem(
                                    undefinedConcept,
                                    "Concept <code>#ref</code> has not been defined",
                                    ProblemHighlightType.GENERIC_ERROR
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    override fun getDisplayName(): String {
        return "Undefined declaration"
    }

    override fun getGroupDisplayName(): String {
        return "TypeQL"
    }

    override fun getShortName(): String {
        return "UndefinedDeclaration"
    }

    override fun isEnabledByDefault(): Boolean {
        return true
    }
}