package com.vaticle.typeql.jetbrains.inspection.invalidTypeUsage

import com.google.common.collect.Sets
import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.vaticle.typeql.jetbrains.psi.PsiTypeQLElement
import com.vaticle.typeql.jetbrains.psi.PsiTypeQLNamedElement
import com.vaticle.typeql.jetbrains.psi.TypeQLPsiUtils
import com.vaticle.typeql.jetbrains.psi.constraint.PsiOwnsTypeConstraint
import com.vaticle.typeql.jetbrains.psi.constraint.PsiPlaysTypeConstraint
import com.vaticle.typeql.jetbrains.psi.constraint.PsiSubTypeConstraint
import com.vaticle.typeql.jetbrains.psi.statement.PsiStatementType
import org.apache.commons.lang.StringUtils

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class TypeQLInvalidTypeUsageInspection : LocalInspectionTool() {
    private val invalidTypeUsages: MutableMap<String, Set<String>>

    init {
        invalidTypeUsages = HashMap()
        invalidTypeUsages["entity"] = Sets.newHashSet("relates", "plays", "owns")
        invalidTypeUsages["role"] = Sets.newHashSet("owns")
        invalidTypeUsages["attribute"] = Sets.newHashSet("plays")
        invalidTypeUsages["relation"] = Sets.newHashSet("plays", "owns")
    }

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {
            override fun visitElement(identifier: PsiElement) {
                if (identifier is PsiTypeQLElement
                    && identifier !is PsiTypeQLNamedElement
                    && identifier !is PsiStatementType
                ) {
                    TypeQLPsiUtils.ensureTypeQLElementsUpToDate(identifier.getContainingFile())
                    val declaration = TypeQLPsiUtils.findDeclaration(
                        identifier.getProject(), identifier
                    )
                    if (declaration != null) {
                        val declarationType = TypeQLPsiUtils.determineDeclarationType(declaration)
                        val usageType: String
                        usageType = if (identifier is PsiPlaysTypeConstraint) {
                            "plays"
                        } else if (identifier is PsiOwnsTypeConstraint) {
                            "owns"
                        } else if (identifier is PsiSubTypeConstraint) {
                            return  //all types can be sub-typed
                        } else {
                            throw UnsupportedOperationException()
                        }
                        if (declarationType != null && invalidTypeUsages[declarationType]!!.contains(usageType)) {
                            holder.registerProblem(
                                identifier.getFirstChild().nextSibling.nextSibling, String.format(
                                    "%s <code>#ref</code> cannot be used as '%s'",
                                    StringUtils.capitalize(declarationType), usageType
                                ),
                                ProblemHighlightType.GENERIC_ERROR
                            )
                        }
                    }
                }
            }
        }
    }

    override fun getDisplayName(): String {
        return "Invalid type usage"
    }

    override fun getGroupDisplayName(): String {
        return "TypeQL"
    }

    override fun getShortName(): String {
        return "InvalidTypeUsage"
    }

    override fun isEnabledByDefault(): Boolean {
        return true
    }
}