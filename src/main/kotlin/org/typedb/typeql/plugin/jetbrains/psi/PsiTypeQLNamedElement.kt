package org.typedb.typeql.plugin.jetbrains.psi

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiNameIdentifierOwner

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */

/**
 * Classification between Named and Referencing elements is needed for referencing purposes
 * (which is a basis for features like "Find Usages", "Find Declaration", "Refactor", etc.).
 * Named elements are the declarations of entities which can be targets for these features.
 * This way, they create new "names" for the language.
 * @ref PsiTypeQLReferencingElement
 *
 * Examples:
 *
 * "my_new_entity" is a named element, declaring a new entity:
 * "define my_new_entity sub entity;"
 *
 * "my_newest_entity" is a named element, declaring a new entity,
 * "my_new_entity" is a referencing element, which only relates to the original named element,
 * but does not create a new name:
 * "define my_newest_entity sub my_new_entity;"
 */
abstract class PsiTypeQLNamedElement(node: ASTNode) : PsiTypeQLElement(node), PsiNameIdentifierOwner {
    override fun getTextRange(): TextRange? = nameIdentifier?.textRange

    override fun getName(): String? = nameIdentifier?.text

    override fun getTextOffset(): Int = nameIdentifier?.textOffset ?: super.getTextOffset()

    override fun toString(): String {
        return String.format(
            "%s(%s) - Name: %s - Location: %s",
            javaClass.simpleName, node.elementType, name, textRange
        )
    }
}
