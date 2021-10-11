package com.vaticle.typeql.jetbrains.psi

import com.intellij.ide.scratch.ScratchUtil
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import com.vaticle.typeql.jetbrains.TypeQLFileType
import com.vaticle.typeql.jetbrains.TypeQLLanguage
import com.vaticle.typeql.jetbrains.psi.constraint.*
import com.vaticle.typeql.jetbrains.psi.statement.PsiStatementType
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import java.util.function.Consumer
import java.util.stream.Collectors

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
object TypeQLPsiUtils {
    fun ensureTypeQLElementsUpToDate(file: PsiFile?) {
        try {
            PsiTreeUtil.collectElementsOfType(file, PsiTypeQLElement::class.java)
                .forEach(Consumer { obj: PsiTypeQLElement -> obj.subtreeChanged() })
        } catch (ignored: Throwable) {
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
            val typeqlFile = PsiManager.getInstance(project).findFile(virtualFile!!) as PsiTypeQLFileBase?
            if (typeqlFile != null) {
                declarations.addAll(PsiTreeUtil.collectElementsOfType(typeqlFile, PsiTypeQLNamedElement::class.java))
            }
        }
        return declarations
    }

    fun findUsages(identifier: PsiTypeQLElement): List<PsiTypeQLElement> {
        val identifierFile = identifier.node.psi.containingFile.virtualFile
        return if (ScratchUtil.isScratch(identifierFile)) {
            findUsages(
                identifier.project,
                identifier,
                identifier.scopedName,
                listOf(identifierFile)
            )
        } else {
            findUsages(
                identifier.project, identifier, identifier.scopedName,
                FileTypeIndex.getFiles(
                    TypeQLFileType.Companion.INSTANCE,
                    GlobalSearchScope.allScope(identifier.project)
                )
            )
        }
    }

    fun findUsages(
        project: Project, element: PsiTypeQLElement,
        name: String?, searchScope: Collection<VirtualFile?>
    ): List<PsiTypeQLElement> {
        //todo: review logic in this method
        val result: MutableList<PsiTypeQLElement> = ArrayList()
        if (name == null) {
            return result
        }
        for (virtualFile in searchScope) {
            val typeqlFile = PsiManager.getInstance(project).findFile(virtualFile!!) as PsiTypeQLFileBase?
            if (typeqlFile != null) {
                if (element is PsiOwnsTypeConstraint) {
                    val ownsIdentifiers = PsiTreeUtil.collectElementsOfType(
                        typeqlFile, PsiOwnsTypeConstraint::class.java
                    )
                    for (identifier in ownsIdentifiers) {
                        if (name == identifier.ownsType) {
                            result.add(identifier)
                        }
                    }
                } else if (element is PsiSubTypeConstraint) {
                    val subTypeIdentifiers = PsiTreeUtil.collectElementsOfType(
                        typeqlFile, PsiSubTypeConstraint::class.java
                    )
                    for (identifier in subTypeIdentifiers) {
                        if (name == identifier.subType) {
                            result.add(identifier)
                        }
                    }
                } else if (element is PsiPlaysTypeConstraint
                    || element is PsiRelatesSuperRoleTypeConstraint
                ) {
                    val playsIdentifiers = PsiTreeUtil.collectElementsOfType(
                        typeqlFile, PsiPlaysTypeConstraint::class.java
                    )
                    for (identifier in playsIdentifiers) {
                        if (name == identifier.playsType) {
                            result.add(identifier)
                        }
                    }
                    val relatesSuperRoleIdentifiers =
                        PsiTreeUtil.collectElementsOfType(typeqlFile, PsiRelatesSuperRoleTypeConstraint::class.java)
                    for (identifier in relatesSuperRoleIdentifiers) {
                        if (name == identifier.text) {
                            result.add(identifier)
                        }
                    }
                } else {
                    val ownsIdentifiers = PsiTreeUtil.collectElementsOfType(
                        typeqlFile, PsiOwnsTypeConstraint::class.java
                    )
                    for (identifier in ownsIdentifiers) {
                        if (name == identifier.ownsType) {
                            result.add(identifier)
                        }
                    }
                    val subTypeIdentifiers = PsiTreeUtil.collectElementsOfType(
                        typeqlFile, PsiSubTypeConstraint::class.java
                    )
                    for (identifier in subTypeIdentifiers) {
                        if (name == identifier.subType) {
                            result.add(identifier)
                        }
                    }
                    val playsIdentifiers = PsiTreeUtil.collectElementsOfType(
                        typeqlFile, PsiPlaysTypeConstraint::class.java
                    )
                    for (identifier in playsIdentifiers) {
                        if (name == identifier.playsType) {
                            result.add(identifier)
                        }
                    }
                    val relatesSuperRoleIdentifiers =
                        PsiTreeUtil.collectElementsOfType(typeqlFile, PsiRelatesSuperRoleTypeConstraint::class.java)
                    for (identifier in relatesSuperRoleIdentifiers) {
                        if (name == identifier.text) {
                            result.add(identifier)
                        }
                    }
                }
            }
        }
        return result
    }

    fun findDeclaration(
        project: Project, name: String?,
        searchScope: Collection<VirtualFile?>
    ): PsiTypeQLNamedElement? {
        val declarations = findDeclarations(project, name, searchScope)
        return if (declarations.isEmpty()) {
            null
        } else {
            declarations[0]
        }
    }

    fun findDeclaration(project: Project, identifier: PsiTypeQLElement): PsiTypeQLNamedElement? {
        val declarations = findDeclarations(project, identifier)
        return if (declarations.isEmpty()) {
            null
        } else {
            declarations[0]
        }
    }

    fun findDeclarations(
        project: Project,
        identifier: PsiTypeQLElement
    ): List<PsiTypeQLNamedElement> {
        val identifierFile = identifier.node.psi.containingFile.virtualFile
        return if (ScratchUtil.isScratch(identifierFile)) {
            findDeclarations(project, identifier.scopedName, listOf(identifierFile))
        } else {
            findDeclarations(
                project, identifier.scopedName, FileTypeIndex.getFiles(
                    TypeQLFileType.Companion.INSTANCE, GlobalSearchScope.allScope(project)
                )
            )
        }
    }

    fun findDeclarations(
        project: Project, name: String?,
        searchScope: Collection<VirtualFile?>
    ): List<PsiTypeQLNamedElement> {
        val declarations: MutableList<PsiTypeQLNamedElement> = ArrayList()
        if (name == null) {
            return declarations
        }
        for (virtualFile in searchScope) {
            val typeqlFile = PsiManager.getInstance(project).findFile(virtualFile!!) as PsiTypeQLFileBase?
            if (typeqlFile != null) {
                val identifiers = PsiTreeUtil.collectElementsOfType(
                    typeqlFile, PsiTypeQLNamedElement::class.java
                )
                for (identifier in identifiers) {
                    if (name == identifier.scopedName) {
                        declarations.add(identifier)
                    }
                }
            }
        }
        return declarations
    }

    fun determineDeclarationType(identifier: PsiTypeQLNamedElement): String? {
        val subType: String?
        subType = if (identifier.parent is PsiStatementType) {
            (identifier.parent as PsiStatementType).subType
        } else {
            (identifier.parent.parent as PsiStatementType).subType
        }
        if (identifier is PsiRelatesTypeConstraint) {
            return "role"
        } else if (TypeQLLanguage.GRAQL_TYPES.contains(subType)) {
            return subType
        }
        val searchScope: Collection<VirtualFile?>
        searchScope = if (ScratchUtil.isScratch(identifier.containingFile.virtualFile)) {
            listOf(identifier.containingFile.virtualFile)
        } else {
            FileTypeIndex.getFiles(
                TypeQLFileType.Companion.INSTANCE,
                GlobalSearchScope.allScope(identifier.project)
            )
        }
        val declaration = findDeclaration(identifier.project, subType, searchScope)
        return if (declaration == null || declaration === identifier) {
            null
        } else {
            determineDeclarationType(declaration)
        }
    }

    fun setName(element: PsiTypeQLElement, newName: String): PsiElement {
        if (element is PsiTypeConstraint) {
            val typeProperty = TypeQLPsiElementFactory.createTypeProperty(element.getProject(), newName)
            element.getParent().node.replaceChild(element.getNode(), typeProperty!!.node)
        } else if (element is PsiSubTypeConstraint) {
            val subTypeProperty = TypeQLPsiElementFactory.createSubTypeProperty(element.getProject(), newName)
            element.getParent().node.replaceChild(element.getNode(), subTypeProperty!!.node)
        } else if (element is PsiRelatesTypeConstraint) {
            val typeProperty = TypeQLPsiElementFactory.createRelatesTypeProperty(element.getProject(), newName)
            element.getNode().replaceChild(
                element.getFirstChild().nextSibling.nextSibling.node,
                typeProperty!!.firstChild.nextSibling.nextSibling.node
            )
        } else if (element is PsiPlaysTypeConstraint) {
            val playsTypeProperty = TypeQLPsiElementFactory.createPlaysTypeProperty(element.getProject(), newName)
            element.getParent().node.replaceChild(element.getNode(), playsTypeProperty!!.node)
        } else {
            throw UnsupportedOperationException()
        }
        return element
    }

    fun findParentByType(
        element: PsiElement,
        ruleElementType: RuleIElementType
    ): PsiTypeQLElement? {
        var parent = element
        while (parent.parent.also { parent = it } != null) {
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