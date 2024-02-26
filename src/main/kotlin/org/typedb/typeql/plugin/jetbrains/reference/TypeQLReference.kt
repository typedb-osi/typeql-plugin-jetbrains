package org.typedb.typeql.plugin.jetbrains.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.util.IncorrectOperationException
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLElement
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLElementFactory
import org.typedb.typeql.plugin.jetbrains.psi.constraint.*
import org.typedb.typeql.plugin.jetbrains.usage.TypeQLDeclarationFinder

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class TypeQLReference(element: PsiTypeQLElement, textRange: TextRange) :
    PsiReferenceBase<PsiTypeQLElement?>(element, textRange) {
    @Throws(IncorrectOperationException::class)
    override fun handleElementRename(newName: String): PsiElement {
        if (myElement == null) {
            throw UnsupportedOperationException("Cannot handle element renaming for not existing element $element")
        }

        val tempProperty: PsiTypeQLElement?
        val renamingElement = myElement!!

        when (renamingElement) {
            is PsiTypeQLSubType -> tempProperty =
                PsiTypeQLElementFactory.createSubTypeProperty(renamingElement.project, newName)

            is PsiTypeQLPlaysType -> tempProperty =
                PsiTypeQLElementFactory.createPlaysTypeProperty(
                    renamingElement.project, renamingElement.buildScopedName(newName)
                )

            is PsiTypeQLOwnsType -> tempProperty =
                PsiTypeQLElementFactory.createOwnsTypeProperty(renamingElement.project, newName)

            is PsiTypeQLRelatesAsOverrideType -> tempProperty =
                PsiTypeQLElementFactory.createRelatesAsOverrideTypeProperty(renamingElement.project, newName)

            is PsiTypeQLPlaysAsOverrideType -> tempProperty =
                PsiTypeQLElementFactory.createPlaysAsOverrideTypeProperty(renamingElement.project, newName)

            is PsiTypeQLOwnsAsOverrideType -> tempProperty =
                PsiTypeQLElementFactory.createOwnsAsOverrideTypeProperty(renamingElement.project, newName)

            else -> throw UnsupportedOperationException("Cannot set name to this element $element")
        }

        if (tempProperty != null) {
            if (renamingElement.labelNode == null || tempProperty.labelNode == null) {
                throw NullPointerException("Cannot access label node for $this")
            }

            renamingElement.labelNode!!.treeParent.replaceChild(
                renamingElement.labelNode!!, tempProperty.labelNode!!
            )
        }

        return renamingElement
    }

    override fun resolve(): PsiElement? {
        return TypeQLDeclarationFinder.findDeclaration(myElement!!.project, myElement!!)
    }

    override fun getVariants(): Array<Any> {
        return emptyArray()
    }

    override fun toString(): String = String.format(
        "%s(%s)",
        javaClass.simpleName, myElement?.node
    )
}
