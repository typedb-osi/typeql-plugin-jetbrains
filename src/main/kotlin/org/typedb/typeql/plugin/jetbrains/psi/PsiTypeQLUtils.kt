package org.typedb.typeql.plugin.jetbrains.psi

import com.intellij.ide.scratch.ScratchUtil
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.typedb.typeql.plugin.jetbrains.TypeQLFileType
import org.typedb.typeql.plugin.jetbrains.TypeQLLanguage
import org.typedb.typeql.plugin.jetbrains.psi.constraint.*
import org.typedb.typeql.plugin.jetbrains.usage.TypeQLDeclarationFinder
import java.util.function.Consumer
import java.util.stream.Collectors

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
object PsiTypeQLUtils {
    fun getDefinables(file: PsiFile): PsiElement? {
        return file.firstChild?.firstChild?.firstChild?.firstChild?.lastChild
    }

    fun ensureTypeQLElementsUpToDate(file: PsiFile?) {
        try {
            PsiTreeUtil.collectElementsOfType(file, PsiTypeQLElement::class.java)
                .forEach(Consumer { obj: PsiTypeQLElement -> obj.subtreeChanged() })
        }
        catch (ignored: Throwable) {
        }
    }

    fun getDeclarationsByType(
        project: Project,
        searchScope: Collection<VirtualFile?>,
        type: String
    ): List<PsiTypeQLNamedElement> {
        return getAllDeclarations(project, searchScope).stream()
            .filter { it: PsiTypeQLNamedElement -> type == determineDeclarationType(it) }
            .collect(Collectors.toList())
    }

    fun getAllDeclarations(
        project: Project,
        searchScope: Collection<VirtualFile?>
    ): List<PsiTypeQLNamedElement> {
        val declarations: MutableList<PsiTypeQLNamedElement> = ArrayList()
        for (virtualFile in searchScope) {
            val typeqlFile = PsiManager.getInstance(project).findFile(virtualFile!!) as PsiTypeQLFile?
            if (typeqlFile != null) {
                declarations.addAll(PsiTreeUtil.collectElementsOfType(typeqlFile, PsiTypeQLNamedElement::class.java))
            }
        }
        return declarations
    }

    fun determineDeclarationType(identifier: PsiTypeQLNamedElement): String? {
        val subType: String?
        subType = if (identifier.parent is PsiTypeQLStatementType) {
            (identifier.parent as PsiTypeQLStatementType).subType
        } else {
            (identifier.parent.parent as PsiTypeQLStatementType).subType
        }
        if (identifier is PsiTypeQLRelatesType) {
            return "role"
        } else if (TypeQLLanguage.TYPEQL_TYPES.contains(subType)) {
            return subType
        }
        val searchScope: Collection<VirtualFile?>
        searchScope = if (ScratchUtil.isScratch(identifier.containingFile.virtualFile)) {
            listOf(identifier.containingFile.virtualFile)
        } else {
            FileTypeIndex.getFiles(
                TypeQLFileType.INSTANCE,
                GlobalSearchScope.allScope(identifier.project)
            )
        }

        val declaration = TypeQLDeclarationFinder.findDeclaration(identifier.project, subType, searchScope)
        return if (declaration == null || declaration === identifier) {
            null
        } else {
            determineDeclarationType(declaration)
        }
    }

    fun findParentByType(
        element: PsiElement,
        ruleElementType: RuleIElementType
    ): PsiTypeQLElement? {
        var parent: PsiElement? = element
        while (parent?.parent.also { parent = it } != null) {
            if (parent is PsiTypeQLElement) {
                val compositeElement = (parent as PsiTypeQLElement).node
                if (compositeElement.elementType === ruleElementType) {
                    return compositeElement.psi as PsiTypeQLElement
                }
            }
        }
        return null
    }
}
