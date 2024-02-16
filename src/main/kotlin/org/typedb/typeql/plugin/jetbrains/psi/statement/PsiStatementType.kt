//package org.typedb.typeql.plugin.jetbrains.psi.statement
//
//import com.intellij.lang.ASTNode
//import org.typedb.typeql.plugin.jetbrains.TypeQLParserDefinition
//import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLElement
//import org.typedb.typeql.plugin.jetbrains.psi.constraint.*
//
///**
// * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
// */
//class PsiStatementType(node: ASTNode) : PsiTypeQLElement(node) {
//
//    override fun getName(): String? = firstChild.text
//
//    //todo: seems wrong
//    val subType: String?
//        get() = if (node.firstChildNode == null ||
//            node.firstChildNode.treeNext == null ||
//            node.firstChildNode.treeNext.treeNext == null ||
//            node.firstChildNode.treeNext.treeNext.lastChildNode == null
//        ) {
//            null
//        } else node.firstChildNode.treeNext.treeNext.lastChildNode.text
//
//    fun findRelatesTypeProperties(): List<PsiRelatesTypeConstraint> {
//        val relatesTypes: MutableList<PsiRelatesTypeConstraint> = ArrayList()
//        for (child in children) {
//            val element = TypeQLParserDefinition.getRuleTypePropertyElement(child.node)
//            if (element is PsiRelatesTypeConstraint) {
//                relatesTypes.add(element)
//            }
//        }
//        return relatesTypes
//    }
//
//    fun findPlaysTypeProperties(): List<PsiPlaysTypeConstraint> {
//        val playsTypes: MutableList<PsiPlaysTypeConstraint> = ArrayList()
//        for (child in children) {
//            val element = TypeQLParserDefinition.getRuleTypePropertyElement(child.node)
//            if (element is PsiPlaysTypeConstraint) {
//                playsTypes.add(element)
//            }
//        }
//        return playsTypes
//    }
//
//    fun findOwnsTypeProperties(): List<PsiOwnsTypeConstraint> {
//        val ownsTypes: MutableList<PsiOwnsTypeConstraint> = ArrayList()
//        for (child in children) {
//            val element = TypeQLParserDefinition.getRuleTypePropertyElement(child.node)
//            if (element is PsiOwnsTypeConstraint) {
//                ownsTypes.add(element)
//            }
//        }
//        return ownsTypes
//    }
//
//    fun findSubTypeProperties(): List<PsiSubTypeConstraint> {
//        val subTypes: MutableList<PsiSubTypeConstraint> = ArrayList()
//        for (child in children) {
//            val element = TypeQLParserDefinition.getRuleTypePropertyElement(child.node)
//            if (element is PsiSubTypeConstraint) {
//                subTypes.add(element)
//            }
//        }
//        return subTypes
//    }
//
//    fun findTypeProperties(): List<PsiTypeConstraint> {
//        val relatesTypes: MutableList<PsiTypeConstraint> = ArrayList()
//        for (child in children) {
//            val element = TypeQLParserDefinition.getRuleTypeElement(child.node)
//            if (element is PsiTypeConstraint) {
//                relatesTypes.add(element)
//            }
//        }
//        return relatesTypes
//    }
//}
