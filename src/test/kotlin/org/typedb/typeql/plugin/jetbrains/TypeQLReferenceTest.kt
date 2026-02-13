package org.typedb.typeql.plugin.jetbrains

import com.intellij.psi.PsiErrorElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.testFramework.ParsingTestCase
import org.typedb.typeql.plugin.jetbrains.psi.*

class TypeQLReferenceTest : ParsingTestCase("", "tql", TypeQLParserDefinition()) {

    override fun getTestDataPath(): String = ""
    override fun skipSpaces(): Boolean = true
    override fun includeRanges(): Boolean = false

    private fun parseText(code: String): TypeQLFile {
        val file = createPsiFile("test", code)
        ensureParsed(file)
        return file as TypeQLFile
    }

    private fun assertNoErrors(file: TypeQLFile) {
        val errors = PsiTreeUtil.findChildrenOfType(file, PsiErrorElement::class.java)
        if (errors.isNotEmpty()) {
            val errorMessages = errors.joinToString("\n") { "  - ${it.errorDescription} at offset ${it.textOffset}" }
            fail("Expected no parse errors, but found ${errors.size}:\n$errorMessages")
        }
    }

    // ---- TypeDefinition as PsiNamedElement ----

    fun testTypeDefinitionHasName() {
        val file = parseText("define entity person sub entity;")
        assertNoErrors(file)
        val typeDef = PsiTreeUtil.findChildOfType(file, TypeQLTypeDefinition::class.java)
        assertNotNull(typeDef)
        assertTrue("TypeQLTypeDefinition should be PsiNamedElement", typeDef is PsiNamedElement)
        assertEquals("person", typeDef!!.name)
    }

    fun testTypeDefinitionNameIdentifier() {
        val file = parseText("define entity person sub entity;")
        assertNoErrors(file)
        val typeDef = PsiTreeUtil.findChildOfType(file, TypeQLTypeDefinition::class.java)!!
        val nameId = typeDef.nameIdentifier
        assertNotNull("Expected a name identifier", nameId)
        assertEquals("person", nameId!!.text)
    }

    fun testTypeDefinitionWithUnreservedKeywordName() {
        val file = parseText("define entity count sub entity;")
        assertNoErrors(file)
        val typeDef = PsiTreeUtil.findChildOfType(file, TypeQLTypeDefinition::class.java)!!
        assertEquals("count", typeDef.name)
    }

    // ---- DefinitionFunction as PsiNamedElement ----

    fun testFunctionDefinitionHasName() {
        val file = parseText("""
            define
            fun age_of(${'$'}p: person) -> integer:
                match ${'$'}p has age ${'$'}a;
                return first ${'$'}a;
        """.trimIndent())
        assertNoErrors(file)
        val funDef = PsiTreeUtil.findChildOfType(file, TypeQLDefinitionFunction::class.java)
        assertNotNull(funDef)
        assertTrue("TypeQLDefinitionFunction should be PsiNamedElement", funDef is PsiNamedElement)
        assertEquals("age_of", funDef!!.name)
    }

    fun testFunctionDefinitionNameIdentifier() {
        val file = parseText("""
            define
            fun my_func(${'$'}x: entity) -> string:
                match ${'$'}x has name ${'$'}n;
                return first ${'$'}n;
        """.trimIndent())
        assertNoErrors(file)
        val funDef = PsiTreeUtil.findChildOfType(file, TypeQLDefinitionFunction::class.java)!!
        val nameId = funDef.nameIdentifier
        assertNotNull("Expected a name identifier", nameId)
        assertEquals("my_func", nameId!!.text)
    }

    // ---- DefinitionStruct as PsiNamedElement ----

    fun testStructDefinitionHasName() {
        val file = parseText("""
            define
            struct coordinates:
                latitude value double,
                longitude value double;
        """.trimIndent())
        assertNoErrors(file)
        val structDef = PsiTreeUtil.findChildOfType(file, TypeQLDefinitionStruct::class.java)
        assertNotNull(structDef)
        assertTrue("TypeQLDefinitionStruct should be PsiNamedElement", structDef is PsiNamedElement)
        assertEquals("coordinates", structDef!!.name)
    }

    // ---- TypeLabel reference behavior ----

    fun testDefinitionTypeLabelResolvesToSelf() {
        val file = parseText("define entity person sub entity;")
        assertNoErrors(file)
        val typeDef = PsiTreeUtil.findChildOfType(file, TypeQLTypeDefinition::class.java)!!
        val nameLabel = typeDef.typeLabel
        // The label that IS the definition should have a reference that resolves to its own TypeDefinition
        val ref = nameLabel.reference
        assertNotNull("Definition's type_label should have a reference", ref)
        val resolved = ref!!.resolve()
        assertSame("Should resolve to its own TypeDefinition", typeDef, resolved)
    }

    fun testSubTypeLabelHasReference() {
        val file = parseText("define entity employee sub person;")
        assertNoErrors(file)
        val typeDef = PsiTreeUtil.findChildOfType(file, TypeQLTypeDefinition::class.java)!!
        val subDecl = PsiTreeUtil.findChildOfType(typeDef, TypeQLSubDeclaration::class.java)!!
        val subLabel = PsiTreeUtil.findChildOfType(subDecl, TypeQLTypeLabel::class.java)!!
        // The label after "sub" is a reference — it should have a reference
        val ref = subLabel.reference
        assertNotNull("Type label in sub declaration should have a reference", ref)
        assertTrue("Reference should be TypeQLTypeReference", ref is TypeQLTypeReference)
    }

    fun testIsaTypeLabelResolvesToDefinition() {
        val file = parseText("""
            define
            entity person sub entity;

            match
            ${'$'}p isa person;
        """.trimIndent())
        assertNoErrors(file)
        val typeDef = PsiTreeUtil.findChildOfType(file, TypeQLTypeDefinition::class.java)!!
        val isaConstraint = PsiTreeUtil.findChildOfType(file, TypeQLIsaConstraint::class.java)!!
        val typeLabels = PsiTreeUtil.findChildrenOfType(isaConstraint, TypeQLTypeLabel::class.java)
        assertFalse("Expected at least one type label in isa constraint", typeLabels.isEmpty())
        val personLabel = typeLabels.first()
        val ref = personLabel.reference
        assertNotNull("Type label in isa should have a reference", ref)
        val resolved = ref!!.resolve()
        assertSame("isa person should resolve to the define entity person", typeDef, resolved)
    }

    fun testSubTypeLabelResolvesToDefinition() {
        val file = parseText("""
            define
            entity person sub entity;
            entity employee sub person;
        """.trimIndent())
        assertNoErrors(file)
        val typeDefs = PsiTreeUtil.findChildrenOfType(file, TypeQLTypeDefinition::class.java).toList()
        val personDef = typeDefs.find { it.name == "person" }!!
        val employeeDef = typeDefs.find { it.name == "employee" }!!
        val subDecl = PsiTreeUtil.findChildOfType(employeeDef, TypeQLSubDeclaration::class.java)!!
        val subLabel = PsiTreeUtil.findChildOfType(subDecl, TypeQLTypeLabel::class.java)!!
        val resolved = subLabel.reference?.resolve()
        assertSame("sub person should resolve to entity person definition", personDef, resolved)
    }

    // ---- ExpressionFunctionName reference behavior ----

    fun testBuiltinFunctionNameHasNoReference() {
        val file = parseText("""
            match
            ${'$'}x isa attribute;
            let ${'$'}y = abs(${'$'}x);
        """.trimIndent())
        assertNoErrors(file)
        val funcName = PsiTreeUtil.findChildOfType(file, TypeQLExpressionFunctionName::class.java)!!
        assertNull("Built-in function name should not have a reference", funcName.reference)
    }

    fun testUserFunctionNameHasReference() {
        val file = parseText("""
            match
            ${'$'}p isa person;
            let ${'$'}a = age_of(${'$'}p);
        """.trimIndent())
        assertNoErrors(file)
        val funcName = PsiTreeUtil.findChildOfType(file, TypeQLExpressionFunctionName::class.java)!!
        val ref = funcName.reference
        assertNotNull("User-defined function name should have a reference", ref)
        assertTrue("Reference should be TypeQLFunctionReference", ref is TypeQLFunctionReference)
    }

    // ---- Variable reference behavior ----

    fun testVariableHasReference() {
        val file = parseText("""
            match
            ${'$'}p isa person;
            ${'$'}p has name ${'$'}n;
        """.trimIndent())
        assertNoErrors(file)
        val vars = PsiTreeUtil.findChildrenOfType(file, TypeQLVar::class.java)
        // $p appears twice, $n once
        assertTrue("Expected at least 3 variables", vars.size >= 3)
        for (v in vars) {
            val ref = v.reference
            assertNotNull("Named variable should have a reference", ref)
            assertTrue("Reference should be TypeQLVariableReference", ref is TypeQLVariableReference)
        }
    }

    fun testAnonymousVariableHasNoReference() {
        val file = parseText("""
            match
            ${'$'}_ isa person;
        """.trimIndent())
        assertNoErrors(file)
        val vars = PsiTreeUtil.findChildrenOfType(file, TypeQLVar::class.java)
        val anonVar = vars.find { it.text == "\$_" }
        assertNotNull("Expected anonymous variable", anonVar)
        assertNull("Anonymous variable should not have a reference", anonVar!!.reference)
    }

    // ---- Variable resolution within a file ----

    fun testVariableResolvesToFirstOccurrence() {
        val file = parseText("""
            match
            ${'$'}p isa person;
            ${'$'}p has name ${'$'}n;
        """.trimIndent())
        assertNoErrors(file)
        val vars = PsiTreeUtil.findChildrenOfType(file, TypeQLVar::class.java).toList()
        val pVars = vars.filter { it.text == "\$p" }
        assertEquals("Expected 2 occurrences of \$p", 2, pVars.size)

        val firstP = pVars[0]
        val secondP = pVars[1]

        // First occurrence resolves to null (it IS the first)
        assertNull("First occurrence should resolve to null (it's the definition)", firstP.reference?.resolve())
        // Second occurrence resolves to first
        val resolved = secondP.reference?.resolve()
        assertNotNull("Second occurrence should resolve to first", resolved)
        assertSame("Should resolve to the first occurrence", firstP, resolved)
    }

    // ---- FindUsagesProvider ----

    fun testFindUsagesProviderCanFindUsagesForTypeDef() {
        val provider = TypeQLFindUsagesProvider()
        val file = parseText("define entity person sub entity;")
        assertNoErrors(file)
        val typeDef = PsiTreeUtil.findChildOfType(file, TypeQLTypeDefinition::class.java)!!
        assertTrue("Should be able to find usages for type definitions", provider.canFindUsagesFor(typeDef))
        assertEquals("type", provider.getType(typeDef))
        assertEquals("person", provider.getDescriptiveName(typeDef))
    }

    fun testFindUsagesProviderCanFindUsagesForFunctionDef() {
        val provider = TypeQLFindUsagesProvider()
        val file = parseText("""
            define
            fun my_func(${'$'}x: entity) -> string:
                match ${'$'}x has name ${'$'}n;
                return first ${'$'}n;
        """.trimIndent())
        assertNoErrors(file)
        val funDef = PsiTreeUtil.findChildOfType(file, TypeQLDefinitionFunction::class.java)!!
        assertTrue("Should be able to find usages for function definitions", provider.canFindUsagesFor(funDef))
        assertEquals("function", provider.getType(funDef))
        assertEquals("my_func", provider.getDescriptiveName(funDef))
    }

    fun testFindUsagesProviderCanFindUsagesForStructDef() {
        val provider = TypeQLFindUsagesProvider()
        val file = parseText("""
            define
            struct coords:
                lat value double,
                lon value double;
        """.trimIndent())
        assertNoErrors(file)
        val structDef = PsiTreeUtil.findChildOfType(file, TypeQLDefinitionStruct::class.java)!!
        assertTrue("Should be able to find usages for struct definitions", provider.canFindUsagesFor(structDef))
        assertEquals("struct", provider.getType(structDef))
        assertEquals("coords", provider.getDescriptiveName(structDef))
    }

    fun testFindUsagesProviderWordsScanner() {
        val provider = TypeQLFindUsagesProvider()
        assertNotNull("WordsScanner should not be null", provider.wordsScanner)
    }

    // ---- TypeQLNamedElement interface ----

    fun testTypeDefinitionImplementsNamedElement() {
        val file = parseText("define entity person sub entity;")
        assertNoErrors(file)
        val typeDef = PsiTreeUtil.findChildOfType(file, TypeQLTypeDefinition::class.java)!!
        assertTrue("Should implement TypeQLNamedElement", typeDef is TypeQLNamedElement)
    }

    fun testFunctionDefinitionImplementsNamedElement() {
        val file = parseText("""
            define
            fun foo(${'$'}x: entity) -> string:
                match ${'$'}x has name ${'$'}n;
                return first ${'$'}n;
        """.trimIndent())
        assertNoErrors(file)
        val funDef = PsiTreeUtil.findChildOfType(file, TypeQLDefinitionFunction::class.java)!!
        assertTrue("Should implement TypeQLNamedElement", funDef is TypeQLNamedElement)
    }

    fun testStructDefinitionImplementsNamedElement() {
        val file = parseText("""
            define
            struct point:
                x value double,
                y value double;
        """.trimIndent())
        assertNoErrors(file)
        val structDef = PsiTreeUtil.findChildOfType(file, TypeQLDefinitionStruct::class.java)!!
        assertTrue("Should implement TypeQLNamedElement", structDef is TypeQLNamedElement)
    }

    // ---- Multiple type definitions ----

    fun testMultipleTypeDefinitionsHaveNames() {
        val file = parseText("""
            define
            entity person sub entity, owns name;
            attribute name sub attribute, value string;
            relation friendship sub relation, relates friend;
        """.trimIndent())
        assertNoErrors(file)
        val typeDefs = PsiTreeUtil.findChildrenOfType(file, TypeQLTypeDefinition::class.java)
        assertEquals(3, typeDefs.size)
        val names = typeDefs.map { it.name }
        assertTrue("person" in names)
        assertTrue("name" in names)
        assertTrue("friendship" in names)
    }

    // ---- Owns declaration type label has reference ----

    fun testOwnsTypeLabelHasReference() {
        val file = parseText("define entity person sub entity, owns name;")
        assertNoErrors(file)
        val ownsDecl = PsiTreeUtil.findChildOfType(file, TypeQLOwnsDeclaration::class.java)!!
        val typeLabel = PsiTreeUtil.findChildOfType(ownsDecl, TypeQLTypeLabel::class.java)!!
        assertNotNull("Type label in owns should have a reference", typeLabel.reference)
    }

    // ---- Unreserved keyword names (issue 1.1 / 3.1) ----

    fun testFunctionWithUnreservedKeywordName() {
        val file = parseText("""
            define
            fun count(${'$'}x: entity) -> integer:
                match ${'$'}x isa entity;
                return check;
        """.trimIndent())
        assertNoErrors(file)
        val funDef = PsiTreeUtil.findChildOfType(file, TypeQLDefinitionFunction::class.java)!!
        assertEquals("count", funDef.name)
        assertNotNull("Name identifier should not be null for keyword-named function", funDef.nameIdentifier)
    }

    fun testStructWithUnreservedKeywordName() {
        val file = parseText("""
            define
            struct list:
                items value string;
        """.trimIndent())
        assertNoErrors(file)
        val structDef = PsiTreeUtil.findChildOfType(file, TypeQLDefinitionStruct::class.java)!!
        assertEquals("list", structDef.name)
        assertNotNull("Name identifier should not be null for keyword-named struct", structDef.nameIdentifier)
    }

    // Note: setName/rename tests require BasePlatformTestCase (PsiFileFactory needs full project)
    // and should be added when cross-file resolution tests are created with that heavier fixture.

    // ---- All built-in function names have no reference ----

    fun testAllBuiltinFunctionNamesHaveNoReference() {
        val builtins = listOf("abs", "ceil", "floor", "round", "len")
        for (name in builtins) {
            val file = parseText("""
                match
                ${'$'}x isa attribute;
                let ${'$'}y = $name(${'$'}x);
            """.trimIndent())
            assertNoErrors(file)
            val funcName = PsiTreeUtil.findChildOfType(file, TypeQLExpressionFunctionName::class.java)!!
            assertNull("Built-in '$name' should not have a reference", funcName.reference)
        }
    }

    // ---- Plays declaration type label has reference ----

    fun testPlaysTypeLabelHasReference() {
        val file = parseText("define entity person sub entity, plays friendship:friend;")
        assertNoErrors(file)
        val playsDecl = PsiTreeUtil.findChildOfType(file, TypeQLPlaysDeclaration::class.java)!!
        val labelScoped = PsiTreeUtil.findChildOfType(playsDecl, TypeQLLabelScoped::class.java)!!
        val typeLabels = PsiTreeUtil.findChildrenOfType(labelScoped, TypeQLTypeLabel::class.java)
        for (label in typeLabels) {
            assertNotNull("Type label in plays should have a reference", label.reference)
        }
    }

    // ---- Variable in function argument ----

    fun testFunctionArgumentVariableHasReference() {
        val file = parseText("""
            define
            fun helper(${'$'}x: entity) -> string:
                match ${'$'}x has name ${'$'}n;
                return first ${'$'}n;
        """.trimIndent())
        assertNoErrors(file)
        val vars = PsiTreeUtil.findChildrenOfType(file, TypeQLVar::class.java).toList()
        val xVars = vars.filter { it.text == "\$x" }
        assertTrue("Expected at least 2 occurrences of \$x", xVars.size >= 2)
        // Second $x (in match) should resolve to first $x (in argument)
        val resolved = xVars[1].reference?.resolve()
        assertNotNull("Second \$x should resolve to first", resolved)
        assertSame("Should resolve to the first occurrence (argument)", xVars[0], resolved)
    }

    // ---- FindUsagesProvider does not accept non-TypeQL elements ----

    fun testFindUsagesProviderRejectsNonTypeQLElements() {
        val provider = TypeQLFindUsagesProvider()
        val file = parseText("match \$p isa person;")
        assertNoErrors(file)
        val var_ = PsiTreeUtil.findChildOfType(file, TypeQLVar::class.java)!!
        // TypeQLVar does not implement TypeQLNamedElement, so canFindUsagesFor should return false
        assertFalse("Should not find usages for variables (not TypeQLNamedElement)", provider.canFindUsagesFor(var_))
    }

    // ---- Relates declaration type labels have reference ----

    fun testRelatesTypeLabelHasReference() {
        val file = parseText("define relation friendship sub relation, relates friend;")
        assertNoErrors(file)
        val relatesDecl = PsiTreeUtil.findChildOfType(file, TypeQLRelatesDeclaration::class.java)!!
        val typeLabels = PsiTreeUtil.findChildrenOfType(relatesDecl, TypeQLTypeLabel::class.java)
        assertFalse("Expected type labels in relates", typeLabels.isEmpty())
        for (label in typeLabels) {
            assertNotNull("Type label in relates should have a reference", label.reference)
        }
    }
}
