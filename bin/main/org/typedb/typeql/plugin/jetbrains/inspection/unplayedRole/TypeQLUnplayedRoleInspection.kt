package org.typedb.typeql.plugin.jetbrains.inspection.unplayedRole

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLElement
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLNamedElement
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLPsiUtils
import org.typedb.typeql.plugin.jetbrains.psi.constraint.PsiPlaysTypeConstraint
import org.typedb.typeql.plugin.jetbrains.psi.statement.PsiStatementType

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class TypeQLUnplayedRoleInspection : LocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {
            override fun visitElement(identifier: PsiElement) {
                if (identifier is PsiTypeQLElement
                    && identifier !is PsiTypeQLNamedElement
                    && identifier !is PsiStatementType
                ) {
                    TypeQLPsiUtils.ensureTypeQLElementsUpToDate(identifier.getContainingFile())
                    val identifierElement = identifier
                    val declaration = TypeQLPsiUtils.findDeclaration(
                        identifier.getProject(), identifierElement
                    )
                    if (declaration != null) {
                        val type = TypeQLPsiUtils.determineDeclarationType(declaration)
                        if ("role" == type) {
                            var isPlayed = false
                            val usages = TypeQLPsiUtils.findUsages(identifierElement)
                            for (usage in usages) {
                                if (usage is PsiPlaysTypeConstraint) {
                                    isPlayed = true
                                    break
                                }
                            }
                            if (!isPlayed) {
                                var problemAlreadyRegistered = false
                                for (problem in holder.results) {
                                    if (problem.psiElement === declaration
                                        && descriptionTemplate == problem.descriptionTemplate
                                    ) {
                                        problemAlreadyRegistered = true
                                        break
                                    }
                                }
                                if (!problemAlreadyRegistered
                                    && declaration.containingFile.isEquivalentTo(identifier.getContainingFile())
                                ) {
                                    holder.registerProblem(
                                        declaration.firstChild.nextSibling.nextSibling,
                                        descriptionTemplate
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private val descriptionTemplate: String
        private get() = "Role <code>#ref</code> is never played"

    override fun getDisplayName(): String {
        return "Unplayed role"
    }

    override fun getGroupDisplayName(): String {
        return "TypeQL"
    }

    override fun getShortName(): String {
        return "UnplayedRole"
    }

    override fun isEnabledByDefault(): Boolean {
        return true
    }
}