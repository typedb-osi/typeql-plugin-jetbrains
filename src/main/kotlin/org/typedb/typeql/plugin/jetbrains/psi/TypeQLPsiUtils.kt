package org.typedb.typeql.plugin.jetbrains.psi

import com.intellij.ide.scratch.ScratchUtil
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import org.typedb.typeql.plugin.jetbrains.TypeQLFileType
import org.typedb.typeql.plugin.jetbrains.psi.constraint.*

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
object TypeQLPsiUtils {
    //    fun ensureTypeQLElementsUpToDate(file: PsiFile?) {
//        try {
//            PsiTreeUtil.collectElementsOfType(file, PsiTypeQLElement::class.java)
//                .forEach(Consumer { obj: PsiTypeQLElement -> obj.subtreeChanged() })
//        } catch (ignored: Throwable) {
//        }
//    }
//
//    fun getDeclarationsByType(
//        project: Project,
//        searchScope: Collection<VirtualFile?>,
//        type: String
//    ): List<PsiTypeQLNamedElement> {
//        return getAllDeclarations(project, searchScope).stream()
//            .filter { it: PsiTypeQLNamedElement -> type == determineDeclarationType(it) }
//            .collect(Collectors.toList())
//    }
//
//    fun getAllDeclarations(
//        project: Project,
//        searchScope: Collection<VirtualFile?>
//    ): List<PsiTypeQLNamedElement> {
//        val declarations: MutableList<PsiTypeQLNamedElement> = ArrayList()
//        for (virtualFile in searchScope) {
//            val typeqlFile = PsiManager.getInstance(project).findFile(virtualFile!!) as PsiTypeQLFile?
//            if (typeqlFile != null) {
//                declarations.addAll(PsiTreeUtil.collectElementsOfType(typeqlFile, PsiTypeQLNamedElement::class.java))
//            }
//        }
//        return declarations
//    }
//
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
                identifier.project,
                identifier,
                identifier.scopedName,
                FileTypeIndex.getFiles(
                    TypeQLFileType.INSTANCE,
                    GlobalSearchScope.allScope(identifier.project)
                )
            )
        }
    }

    fun findUsages(
        project: Project, element: PsiTypeQLElement,
        name: String?, searchScope: Collection<VirtualFile?>
    ): List<PsiTypeQLElement> {
        val result: MutableList<PsiTypeQLElement> = ArrayList()
        println("FIND USAGES FOR ELEMENT ${element.text}  WITH NAME ${name}!")
        if (name == null) {
            return result
        }
        println("FIND USAGES FOR ELEMENT ${element.text}!")
        for (virtualFile in searchScope) {
            val typeqlFile = PsiManager.getInstance(project).findFile(virtualFile!!) as PsiTypeQLFile? ?: continue

            if (element is PsiOwnsAsSuperRoleTypeConstraint) {
                addOwnsAsSuperRoleTypeElements(result, typeqlFile, name)
                addOwnsTypeElements(result, typeqlFile, name)
                addPlaysAsSuperRoleTypeElements(result, typeqlFile, name)
                addPlaysTypeElements(result, typeqlFile, name)
                addRelatesAsSuperRoleTypeElements(result, typeqlFile, name)
                addSubTypeElements(result, typeqlFile, name)
                addTypeElements(result, typeqlFile, name)
            } else if (element is PsiOwnsTypeConstraint) {
                addOwnsAsSuperRoleTypeElements(result, typeqlFile, name)
                addOwnsTypeElements(result, typeqlFile, name)
                addPlaysAsSuperRoleTypeElements(result, typeqlFile, name)
                addPlaysTypeElements(result, typeqlFile, name)
                addRelatesAsSuperRoleTypeElements(result, typeqlFile, name)
                addSubTypeElements(result, typeqlFile, name)
            } else if (element is PsiPlaysAsSuperRoleTypeConstraint) {
                addOwnsAsSuperRoleTypeElements(result, typeqlFile, name)
                addOwnsTypeElements(result, typeqlFile, name)
                addPlaysAsSuperRoleTypeElements(result, typeqlFile, name)
                addPlaysTypeElements(result, typeqlFile, name)
                addRelatesAsSuperRoleTypeElements(result, typeqlFile, name)
                addSubTypeElements(result, typeqlFile, name)
                addTypeElements(result, typeqlFile, name)
            } else if (element is PsiPlaysTypeConstraint) {
                addOwnsAsSuperRoleTypeElements(result, typeqlFile, name)
                addOwnsTypeElements(result, typeqlFile, name)
                addPlaysAsSuperRoleTypeElements(result, typeqlFile, name)
                addPlaysTypeElements(result, typeqlFile, name)
                addRelatesAsSuperRoleTypeElements(result, typeqlFile, name)
                addSubTypeElements(result, typeqlFile, name)
            } else if (element is PsiRelatesAsSuperRoleTypeConstraint) {
                print("ADDING FOR SUPER ROLE RELATES: $result")
                addOwnsAsSuperRoleTypeElements(result, typeqlFile, name)
                addOwnsTypeElements(result, typeqlFile, name)
                addPlaysAsSuperRoleTypeElements(result, typeqlFile, name)
                addPlaysTypeElements(result, typeqlFile, name)
                addRelatesAsSuperRoleTypeElements(result, typeqlFile, name)
                addSubTypeElements(result, typeqlFile, name)
                print("ADDING FOR SUPER ROLE RELATES END: $result")
            } else if (element is PsiRelatesTypeConstraint) {
                addOwnsAsSuperRoleTypeElements(result, typeqlFile, name)
                addOwnsTypeElements(result, typeqlFile, name)
                addPlaysAsSuperRoleTypeElements(result, typeqlFile, name)
                addPlaysTypeElements(result, typeqlFile, name)
                addRelatesAsSuperRoleTypeElements(result, typeqlFile, name)
                addSubTypeElements(result, typeqlFile, name)
            } else if (element is PsiSubTypeConstraint) {
                addOwnsAsSuperRoleTypeElements(result, typeqlFile, name)
                addOwnsTypeElements(result, typeqlFile, name)
                addPlaysAsSuperRoleTypeElements(result, typeqlFile, name)
                addPlaysTypeElements(result, typeqlFile, name)
                addRelatesAsSuperRoleTypeElements(result, typeqlFile, name)
                addSubTypeElements(result, typeqlFile, name)
            } else if (element is PsiTypeConstraint) {
                addOwnsAsSuperRoleTypeElements(result, typeqlFile, name)
                addOwnsTypeElements(result, typeqlFile, name)
                addPlaysAsSuperRoleTypeElements(result, typeqlFile, name)
                addPlaysTypeElements(result, typeqlFile, name)
                addRelatesAsSuperRoleTypeElements(result, typeqlFile, name)
                addSubTypeElements(result, typeqlFile, name)
            } else {
                throw UnsupportedOperationException("This branch is not expected...")
                addOwnsAsSuperRoleTypeElements(result, typeqlFile, name)
                addOwnsTypeElements(result, typeqlFile, name)
                addPlaysAsSuperRoleTypeElements(result, typeqlFile, name)
                addPlaysTypeElements(result, typeqlFile, name)
                addRelatesAsSuperRoleTypeElements(result, typeqlFile, name)
                addSubTypeElements(result, typeqlFile, name)
            }
        }

        return result
    }

    fun addOwnsTypeElements(
        outResult: MutableList<PsiTypeQLElement>, rootElement: PsiElement, targetName: String? = null
    ) {
        val ownsIdentifiers = PsiTreeUtil.collectElementsOfType(
            rootElement, PsiOwnsTypeConstraint::class.java
        )
        for (identifier in ownsIdentifiers)
        {
            if ((targetName ?: identifier.ownsType) == identifier.ownsType) {
                outResult.add(identifier)
            }
        }
    }

    fun addOwnsAsSuperRoleTypeElements(
        outResult: MutableList<PsiTypeQLElement>, rootElement: PsiElement, targetName: String? = null
    ) {
        val identifiers = PsiTreeUtil.collectElementsOfType(
            rootElement, PsiOwnsAsSuperRoleTypeConstraint::class.java
        )
        for (identifier in identifiers) {
            if ((targetName ?: identifier.text) == identifier.text) {
                outResult.add(identifier)
            }
        }
    }

    fun addSubTypeElements(
        outResult: MutableList<PsiTypeQLElement>, rootElement: PsiElement, targetName: String? = null
    ) {
        val identifiers = PsiTreeUtil.collectElementsOfType(
            rootElement, PsiSubTypeConstraint::class.java
        )
        for (identifier in identifiers) {
            if ((targetName ?: identifier.subType) == identifier.subType) {
                outResult.add(identifier)
            }
        }
    }

    fun addPlaysTypeElements(
        outResult: MutableList<PsiTypeQLElement>, rootElement: PsiElement, targetName: String? = null
    ) {
        val identifiers = PsiTreeUtil.collectElementsOfType(
            rootElement, PsiPlaysTypeConstraint::class.java
        )
        for (identifier in identifiers) {
            if ((targetName ?: identifier.playsType) == identifier.playsType) {
                outResult.add(identifier)
            }
        }
    }

    fun addPlaysAsSuperRoleTypeElements(
        outResult: MutableList<PsiTypeQLElement>, rootElement: PsiElement, targetName: String? = null
    ) {
        val identifiers = PsiTreeUtil.collectElementsOfType(
            rootElement, PsiPlaysAsSuperRoleTypeConstraint::class.java
        )
        for (identifier in identifiers) {
            if ((targetName ?: identifier.text) == identifier.text) {
                outResult.add(identifier)
            }
        }
    }

    fun addRelatesTypeElements(
        outResult: MutableList<PsiTypeQLElement>, rootElement: PsiElement, targetName: String? = null
    ) {
        val identifiers = PsiTreeUtil.collectElementsOfType(
            rootElement, PsiRelatesTypeConstraint::class.java
        )
        for (identifier in identifiers) {
            if ((targetName ?: identifier.scopedName) == identifier.scopedName) {
                outResult.add(identifier)
            }
        }
    }

    fun addRelatesAsSuperRoleTypeElements(
        outResult: MutableList<PsiTypeQLElement>, rootElement: PsiElement, targetName: String? = null
    ) {
        val identifiers = PsiTreeUtil.collectElementsOfType(
            rootElement, PsiRelatesAsSuperRoleTypeConstraint::class.java
        )
        for (identifier in identifiers) {
            if ((targetName ?: identifier.text) == identifier.text) {
                outResult.add(identifier)
            }
        }
    }

    fun addTypeElements(
        outResult: MutableList<PsiTypeQLElement>, rootElement: PsiElement, targetName: String? = null
    ) {
        val identifiers = PsiTreeUtil.collectElementsOfType(
            rootElement, PsiTypeConstraint::class.java
        )
        for (identifier in identifiers) {
            if ((targetName ?: identifier.scopedName) == identifier.scopedName) {
                outResult.add(identifier)
            }
        }
    }
//
//    fun findDeclaration(
//        project: Project, name: String?,
//        searchScope: Collection<VirtualFile?>
//    ): PsiTypeQLNamedElement? {
//        val declarations = findDeclarations(project, name, searchScope)
//        return if (declarations.isEmpty()) {
//            null
//        } else {
//            declarations[0]
//        }
//    }
//
//    fun findDeclaration(project: Project, identifier: PsiTypeQLElement): PsiTypeQLNamedElement? {
//        val declarations = findDeclarations(project, identifier)
//        return if (declarations.isEmpty()) {
//            null
//        } else {
//            declarations[0]
//        }
//    }
//
//    fun findDeclarations(
//        project: Project,
//        identifier: PsiTypeQLElement
//    ): List<PsiTypeQLNamedElement> {
//        val identifierFile = identifier.node.psi.containingFile.virtualFile
//        return if (ScratchUtil.isScratch(identifierFile)) {
//            findDeclarations(project, identifier.scopedName, listOf(identifierFile))
//        } else {
//            findDeclarations(
//                project, identifier.scopedName, FileTypeIndex.getFiles(
//                    TypeQLFileType.INSTANCE, GlobalSearchScope.allScope(project)
//                )
//            )
//        }
//    }
//
//    fun findDeclarations(
//        project: Project, name: String?,
//        searchScope: Collection<VirtualFile?>
//    ): List<PsiTypeQLNamedElement> {
//        val declarations: MutableList<PsiTypeQLNamedElement> = ArrayList()
//        if (name == null) {
//            return declarations
//        }
//        for (virtualFile in searchScope) {
//            val typeqlFile = PsiManager.getInstance(project).findFile(virtualFile!!) as PsiTypeQLFile?
//            if (typeqlFile != null) {
//                val identifiers = PsiTreeUtil.collectElementsOfType(
//                    typeqlFile, PsiTypeQLNamedElement::class.java
//                )
//                for (identifier in identifiers) {
//                    if (name == identifier.scopedName) {
//                        declarations.add(identifier)
//                    }
//                }
//            }
//        }
//        return declarations
//    }
//
//    fun determineDeclarationType(identifier: PsiTypeQLNamedElement): String? {
//        val subType: String?
//        subType = if (identifier.parent is PsiStatementType) {
//            (identifier.parent as PsiStatementType).subType
//        } else {
//            (identifier.parent.parent as PsiStatementType).subType
//        }
//        if (identifier is PsiRelatesTypeConstraint) {
//            return "role"
//        } else if (TypeQLLanguage.TYPEQL_TYPES.contains(subType)) {
//            return subType
//        }
//        val searchScope: Collection<VirtualFile?>
//        searchScope = if (ScratchUtil.isScratch(identifier.containingFile.virtualFile)) {
//            listOf(identifier.containingFile.virtualFile)
//        } else {
//            FileTypeIndex.getFiles(
//                TypeQLFileType.INSTANCE,
//                GlobalSearchScope.allScope(identifier.project)
//            )
//        }
//
//        val declaration = findDeclaration(identifier.project, subType, searchScope)
//        return if (declaration == null || declaration === identifier) {
//            null
//        } else {
//            determineDeclarationType(declaration)
//        }
//    }

    fun setName(element: PsiTypeQLElement, newName: String): PsiElement {
        if (element is PsiTypeConstraint) {
            val typeProperty = TypeQLPsiElementFactory.createTypeProperty(element.getProject(), newName)
            element.getParent().node.replaceChild(element.getNode(), typeProperty.node)
        } else if (element is PsiSubTypeConstraint) {
            val subTypeProperty = TypeQLPsiElementFactory.createSubTypeProperty(element.getProject(), newName)
            element.getParent().node.replaceChild(element.getNode(), subTypeProperty.node)
        } else if (element is PsiRelatesTypeConstraint) {
            val typeProperty = TypeQLPsiElementFactory.createRelatesTypeProperty(element.getProject(), newName)
            element.getNode().replaceChild(
                element.getFirstChild().nextSibling.nextSibling.node,
                typeProperty.firstChild.nextSibling.nextSibling.node
            )
        } else if (element is PsiPlaysTypeConstraint) {
            val playsTypeProperty = TypeQLPsiElementFactory.createPlaysTypeProperty(element.getProject(), newName)
            element.getParent().node.replaceChild(element.getNode(), playsTypeProperty.node)
        } else {
            throw UnsupportedOperationException("Can not set name to this element")
        }

        return element
    }
//
//    fun findParentByType(
//        element: PsiElement,
//        ruleElementType: RuleIElementType
//    ): PsiTypeQLElement? {
//        var parent: PsiElement? = element
//        while (parent?.parent.also { parent = it } != null) {
//            if (parent is PsiTypeQLElement) {
//                val compositeElement = (parent as PsiTypeQLElement).node
//                if (compositeElement.elementType === ruleElementType) {
//                    return compositeElement.psi as PsiTypeQLElement
//                }
//            }
//        }
//        return null
//    }
}
