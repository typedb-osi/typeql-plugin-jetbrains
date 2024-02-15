package org.typedb.typeql.plugin.jetbrains.inspection.unusedDeclaration

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLPsiUtils
import org.typedb.typeql.plugin.jetbrains.psi.statement.PsiStatementType
import org.apache.commons.lang.StringUtils
import org.typedb.typeql.plugin.jetbrains.TypeQLFileType

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
                                holder.registerProblem(
                                    declaration.firstChild.nextSibling.nextSibling,
                                    "Role <code>#ref</code> is never used"
                                )
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
        return TypeQLFileType.LANG_NAME
    }

    override fun getShortName(): String {
        return "UnusedRoleDeclaration"
    }

    override fun isEnabledByDefault(): Boolean {
        return true
    }
}
