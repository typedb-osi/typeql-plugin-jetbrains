//package org.typedb.typeql.plugin.jetbrains.psi.constraint
//
//import com.intellij.lang.ASTNode
//import com.intellij.openapi.util.TextRange
//import com.intellij.psi.PsiReference
//import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry
//import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLElement
//
///**
// * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
// */
//class PsiSubTypeConstraint(node: ASTNode) : PsiTypeQLElement(node) {
//    val subTypeTextRange: TextRange
//        get() = TextRange(4, 4 + subType!!.length)
//    val subType: String?
//        get() = if (lastChild != null) {
//            lastChild.text
//        } else null
//
//    override fun getReference(): PsiReference? {
//        if (subType == null) {
//            return null
//        }
//        val references = ReferenceProvidersRegistry.getReferencesFromProviders(this)
//        return if (references.size > 0) references[0] else null
//    }
//}