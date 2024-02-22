package org.typedb.typeql.plugin.jetbrains.psi

import com.intellij.psi.PsiElement
import org.typedb.typeql.plugin.jetbrains.psi.constraint.*

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
object PsiTypeQLUtils {
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
//    fun findUsages(identifier: PsiTypeQLElement): List<PsiTypeQLElement> {
//        val identifierFile = identifier.node.psi.containingFile.virtualFile
//        return if (ScratchUtil.isScratch(identifierFile)) {
//            findUsages(
//                identifier.project,
//                identifier,
//                identifier.scopedName,
//                listOf(identifierFile)
//            )
//        } else {
//            findUsages(
//                identifier.project,
//                identifier,
//                identifier.scopedName,
//                FileTypeIndex.getFiles(
//                    TypeQLFileType.INSTANCE,
//                    GlobalSearchScope.allScope(identifier.project)
//                )
//            )
//        }
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
        if (element is PsiTypeQLType) {
            val typeProperty = PsiTypeQLElementFactory.createTypeProperty(element.getProject(), newName)
            element.getParent().node.replaceChild(element.getNode(), typeProperty.node)
        } else if (element is PsiTypeQLSubType) {
            val subTypeProperty = PsiTypeQLElementFactory.createSubTypeProperty(element.getProject(), newName)
            element.getParent().node.replaceChild(element.getNode(), subTypeProperty.node)
        } else if (element is PsiTypeQLRelatesType) {
            val typeProperty = PsiTypeQLElementFactory.createRelatesTypeProperty(element.getProject(), newName)
            element.getNode().replaceChild(
                element.getFirstChild().nextSibling.nextSibling.node,
                typeProperty.firstChild.nextSibling.nextSibling.node
            )
        } else if (element is PsiTypeQLPlaysType) {
            val playsTypeProperty = PsiTypeQLElementFactory.createPlaysTypeProperty(element.getProject(), newName)
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
