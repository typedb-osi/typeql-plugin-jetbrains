package org.typedb.typeql.plugin.jetbrains

import com.intellij.psi.PsiErrorElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.testFramework.ParsingTestCase
import org.typedb.typeql.plugin.jetbrains.psi.*

class TypeQLParserTest : ParsingTestCase("", "tql", TypeQLParserDefinition()) {

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
            fail("Expected no parse errors, but found ${errors.size}:\n$errorMessages\n\nPSI tree:\n${file.node.text}")
        }
    }

    // ---- Define queries ----

    fun testDefineEntitySimple() {
        val file = parseText("define entity person sub entity;")
        assertNoErrors(file)
        val define = PsiTreeUtil.findChildOfType(file, TypeQLDefineQuery::class.java)
        assertNotNull("Expected a define_query", define)
        val typeDefs = PsiTreeUtil.findChildrenOfType(define, TypeQLTypeDefinition::class.java)
        assertEquals(1, typeDefs.size)
    }

    fun testDefineEntityWithCapabilities() {
        val file = parseText("""
            define
            entity person sub entity,
                owns name,
                owns age,
                plays friendship:friend;
        """.trimIndent())
        assertNoErrors(file)
        val typeDefs = PsiTreeUtil.findChildrenOfType(file, TypeQLTypeDefinition::class.java)
        assertEquals(1, typeDefs.size)
        val ownsCaps = PsiTreeUtil.findChildrenOfType(file, TypeQLOwnsDeclaration::class.java)
        assertEquals(2, ownsCaps.size)
        val playsCaps = PsiTreeUtil.findChildrenOfType(file, TypeQLPlaysDeclaration::class.java)
        assertEquals(1, playsCaps.size)
    }

    fun testDefineRelation() {
        val file = parseText("""
            define
            relation friendship sub relation,
                relates friend @card(2..2);
        """.trimIndent())
        assertNoErrors(file)
        val relatesCaps = PsiTreeUtil.findChildrenOfType(file, TypeQLRelatesDeclaration::class.java)
        assertEquals(1, relatesCaps.size)
        val annotations = PsiTreeUtil.findChildrenOfType(file, TypeQLAnnotationWithArgs::class.java)
        assertEquals(1, annotations.size)
    }

    fun testDefineAttribute() {
        val file = parseText("define attribute name sub attribute, value string;")
        assertNoErrors(file)
        val valueCaps = PsiTreeUtil.findChildrenOfType(file, TypeQLValueTypeDeclaration::class.java)
        assertEquals(1, valueCaps.size)
    }

    fun testDefineMultipleTypes() {
        val file = parseText("""
            define
            entity person sub entity, owns name;
            attribute name sub attribute, value string;
            attribute age sub attribute, value integer;
        """.trimIndent())
        assertNoErrors(file)
        val typeDefs = PsiTreeUtil.findChildrenOfType(file, TypeQLTypeDefinition::class.java)
        assertEquals(3, typeDefs.size)
    }

    // ---- Pipeline queries ----

    fun testMatchInsertPipeline() {
        val file = parseText("""
            match
            ${'$'}p isa person;
            insert
            ${'$'}p has name "Alice";
        """.trimIndent())
        assertNoErrors(file)
        val matchClause = PsiTreeUtil.findChildOfType(file, TypeQLMatchClause::class.java)
        assertNotNull("Expected a match clause", matchClause)
        val insertClause = PsiTreeUtil.findChildOfType(file, TypeQLInsertClause::class.java)
        assertNotNull("Expected an insert clause", insertClause)
    }

    fun testMatchWithStreamOperators() {
        val file = parseText("""
            match
            ${'$'}p isa person, has name ${'$'}n;
            select ${'$'}p, ${'$'}n;
            sort ${'$'}n asc;
            offset 10;
            limit 5;
        """.trimIndent())
        assertNoErrors(file)
        assertNotNull(PsiTreeUtil.findChildOfType(file, TypeQLSelectOperator::class.java))
        assertNotNull(PsiTreeUtil.findChildOfType(file, TypeQLSortOperator::class.java))
        assertNotNull(PsiTreeUtil.findChildOfType(file, TypeQLOffsetOperator::class.java))
        assertNotNull(PsiTreeUtil.findChildOfType(file, TypeQLLimitOperator::class.java))
    }

    fun testMatchFetchPipeline() {
        val file = parseText("""
            match
            ${'$'}p isa person;
            fetch {
                "name": ${'$'}p.name
            };
        """.trimIndent())
        assertNoErrors(file)
        val fetchClause = PsiTreeUtil.findChildOfType(file, TypeQLFetchClause::class.java)
        assertNotNull("Expected a fetch clause", fetchClause)
        val fetchEntry = PsiTreeUtil.findChildOfType(file, TypeQLFetchObjectEntry::class.java)
        assertNotNull("Expected a fetch object entry", fetchEntry)
    }

    // ---- Function definition ----

    fun testFunctionDefinition() {
        val file = parseText("""
            define
            fun shortest_path(${'$'}a: person, ${'$'}b: person) -> duration:
                match
                ${'$'}a has name ${'$'}d;
                return first ${'$'}d;
        """.trimIndent())
        val errors = PsiTreeUtil.findChildrenOfType(file, PsiErrorElement::class.java)
        if (errors.isNotEmpty()) {
            System.err.println("PSI tree: " + file.text)
            for (e in errors) {
                System.err.println("ERROR: '${e.errorDescription}' at offset ${e.textOffset}, text around: '${file.text.substring(maxOf(0, e.textOffset - 10), minOf(file.text.length, e.textOffset + 20))}'")
            }
        }
        assertNoErrors(file)
        val funDef = PsiTreeUtil.findChildrenOfType(file, TypeQLDefinitionFunction::class.java)
        assertEquals(1, funDef.size)
        val signature = PsiTreeUtil.findChildOfType(funDef.first(), TypeQLFunctionSignature::class.java)
        assertNotNull("Expected a function signature", signature)
        val args = PsiTreeUtil.findChildrenOfType(signature, TypeQLFunctionArgument::class.java)
        assertEquals(2, args.size)
    }

    // ---- Struct definition ----

    fun testStructDefinition() {
        val file = parseText("""
            define
            struct coordinates:
                latitude value double,
                longitude value double;
        """.trimIndent())
        assertNoErrors(file)
        val structDef = PsiTreeUtil.findChildrenOfType(file, TypeQLDefinitionStruct::class.java)
        assertEquals(1, structDef.size)
        val fields = PsiTreeUtil.findChildrenOfType(structDef.first(), TypeQLStructField::class.java)
        assertEquals(2, fields.size)
    }

    // ---- Pattern constructs ----

    fun testDisjunction() {
        val file = parseText("""
            match
            { ${'$'}p isa person; } or { ${'$'}p isa entity; };
        """.trimIndent())
        assertNoErrors(file)
        val disjunction = PsiTreeUtil.findChildOfType(file, TypeQLPatternDisjunction::class.java)
        assertNotNull("Expected a pattern disjunction", disjunction)
    }

    fun testNegation() {
        val file = parseText("""
            match
            ${'$'}p isa person;
            not { ${'$'}p has name "Bob"; };
        """.trimIndent())
        assertNoErrors(file)
        val negation = PsiTreeUtil.findChildOfType(file, TypeQLPatternNegation::class.java)
        assertNotNull("Expected a pattern negation", negation)
    }

    fun testTryBlock() {
        val file = parseText("""
            match
            ${'$'}p isa person;
            try { ${'$'}p has age ${'$'}a; };
        """.trimIndent())
        assertNoErrors(file)
        val tryBlock = PsiTreeUtil.findChildOfType(file, TypeQLPatternTry::class.java)
        assertNotNull("Expected a pattern try", tryBlock)
    }

    // ---- Expressions ----

    fun testArithmeticExpression() {
        val file = parseText("""
            match
            ${'$'}x isa attribute;
            ${'$'}y isa attribute;
            let ${'$'}z = ${'$'}x + ${'$'}y * 2;
        """.trimIndent())
        assertNoErrors(file)
        val assignment = PsiTreeUtil.findChildOfType(file, TypeQLStatementAssignment::class.java)
        assertNotNull("Expected a statement assignment", assignment)
    }

    fun testFunctionCallExpression() {
        val file = parseText("""
            match
            ${'$'}x isa attribute;
            let ${'$'}y = abs(${'$'}x);
        """.trimIndent())
        assertNoErrors(file)
        val funcCall = PsiTreeUtil.findChildOfType(file, TypeQLExpressionFunction::class.java)
        assertNotNull("Expected a function call expression", funcCall)
    }

    // ---- Error recovery ----

    fun testErrorRecoveryPartialInput() {
        // Incomplete define — should still produce a partial PSI tree with a define_query
        val file = parseText("define entity person")
        val define = PsiTreeUtil.findChildOfType(file, TypeQLDefineQuery::class.java)
        assertNotNull("Expected a define_query even for incomplete input", define)
    }

    fun testErrorRecoveryMultipleQueries() {
        // First query has an error, second query should still parse
        val file = parseText("""
            define entity person ???;
            match ${'$'}p isa person;
        """.trimIndent())
        // We should get at least a define_query and a match_clause despite the error
        val define = PsiTreeUtil.findChildOfType(file, TypeQLDefineQuery::class.java)
        assertNotNull("Expected define_query even with errors", define)
    }

    // ---- Sub! and isa! ----

    fun testSubExact() {
        val file = parseText("define entity employee sub! person;")
        assertNoErrors(file)
        val subDecl = PsiTreeUtil.findChildOfType(file, TypeQLSubDeclaration::class.java)
        assertNotNull("Expected a sub declaration", subDecl)
    }

    fun testIsaExact() {
        val file = parseText("""
            match
            ${'$'}p isa! person;
        """.trimIndent())
        assertNoErrors(file)
        val isaCon = PsiTreeUtil.findChildOfType(file, TypeQLIsaConstraint::class.java)
        assertNotNull("Expected an isa constraint", isaCon)
    }

    // ---- Reduce operator ----

    fun testReduceWithGroupby() {
        val file = parseText("""
            match
            ${'$'}p isa person, has age ${'$'}a;
            reduce ${'$'}count = count(${'$'}p), ${'$'}total = sum(${'$'}a) groupby ${'$'}a;
        """.trimIndent())
        assertNoErrors(file)
        val reduce = PsiTreeUtil.findChildOfType(file, TypeQLReduceOperator::class.java)
        assertNotNull("Expected a reduce operator", reduce)
        val reducers = PsiTreeUtil.findChildrenOfType(reduce, TypeQLReducer::class.java)
        assertEquals(2, reducers.size)
    }

    // ---- Distinct and require operators ----

    fun testDistinctOperator() {
        val file = parseText("""
            match
            ${'$'}p isa person;
            distinct;
        """.trimIndent())
        assertNoErrors(file)
        assertNotNull(PsiTreeUtil.findChildOfType(file, TypeQLDistinctOperator::class.java))
    }

    fun testRequireOperator() {
        val file = parseText("""
            match
            ${'$'}p isa person;
            try { ${'$'}p has age ${'$'}a; };
            require ${'$'}a;
        """.trimIndent())
        assertNoErrors(file)
        assertNotNull(PsiTreeUtil.findChildOfType(file, TypeQLRequireOperator::class.java))
    }

    // ---- Let-in expression ----

    fun testLetInExpression() {
        val file = parseText("""
            match
            ${'$'}p isa person;
            let ${'$'}x, ${'$'}y in some_func(${'$'}p);
        """.trimIndent())
        assertNoErrors(file)
        val stmtIn = PsiTreeUtil.findChildOfType(file, TypeQLStatementIn::class.java)
        assertNotNull("Expected a statement_in", stmtIn)
    }

    // ---- Is statement ----

    fun testIsStatement() {
        val file = parseText("""
            match
            ${'$'}p isa person;
            ${'$'}q isa person;
            ${'$'}p is ${'$'}q;
        """.trimIndent())
        assertNoErrors(file)
        val isStmt = PsiTreeUtil.findChildOfType(file, TypeQLStatementIs::class.java)
        assertNotNull("Expected a statement_is", isStmt)
    }

    // ---- IID constraint ----

    fun testIidConstraint() {
        val file = parseText("""
            match
            ${'$'}p iid 0x1234abcd;
        """.trimIndent())
        assertNoErrors(file)
        val iid = PsiTreeUtil.findChildOfType(file, TypeQLIidConstraint::class.java)
        assertNotNull("Expected an iid constraint", iid)
    }

    // ---- Undefine ----

    fun testUndefineCapability() {
        val file = parseText("""
            undefine
            owns name from person;
        """.trimIndent())
        assertNoErrors(file)
        val undefine = PsiTreeUtil.findChildOfType(file, TypeQLUndefineQuery::class.java)
        assertNotNull("Expected an undefine_query", undefine)
        val cap = PsiTreeUtil.findChildOfType(undefine, TypeQLUndefineCapability::class.java)
        assertNotNull("Expected an undefine_capability", cap)
    }

    // ---- Redefine ----

    fun testRedefineType() {
        val file = parseText("""
            redefine
            entity person owns email;
        """.trimIndent())
        assertNoErrors(file)
        val redefine = PsiTreeUtil.findChildOfType(file, TypeQLRedefineQuery::class.java)
        assertNotNull("Expected a redefine_query", redefine)
    }

    // ---- Put and update ----

    fun testPutClause() {
        val file = parseText("""
            put
            ${'$'}p isa person, has name "Alice";
        """.trimIndent())
        assertNoErrors(file)
        assertNotNull(PsiTreeUtil.findChildOfType(file, TypeQLPutClause::class.java))
    }

    fun testUpdateClause() {
        val file = parseText("""
            match
            ${'$'}p isa person, has name "Alice";
            update
            ${'$'}p has name "Bob";
        """.trimIndent())
        assertNoErrors(file)
        assertNotNull(PsiTreeUtil.findChildOfType(file, TypeQLUpdateClause::class.java))
    }

    // ---- Delete with try ----

    fun testDeleteWithTry() {
        val file = parseText("""
            match
            ${'$'}p isa person, has name ${'$'}n;
            delete
            try { has ${'$'}n of ${'$'}p; };
        """.trimIndent())
        assertNoErrors(file)
        assertNotNull(PsiTreeUtil.findChildOfType(file, TypeQLDeleteClause::class.java))
        assertNotNull(PsiTreeUtil.findChildOfType(file, TypeQLPatternTryDeletable::class.java))
    }

    // ---- Return variants ----

    fun testReturnStream() {
        val file = parseText("""
            define
            fun get_names(${'$'}a: person) -> { string }:
                match
                ${'$'}a has name ${'$'}n;
                return { ${'$'}n };
        """.trimIndent())
        assertNoErrors(file)
        assertNotNull(PsiTreeUtil.findChildOfType(file, TypeQLReturnStreamBody::class.java))
    }

    fun testReturnReduce() {
        val file = parseText("""
            define
            fun count_friends(${'$'}a: person) -> integer:
                match
                ${'$'}a has name ${'$'}n;
                return check;
        """.trimIndent())
        assertNoErrors(file)
        assertNotNull(PsiTreeUtil.findChildOfType(file, TypeQLReturnReduceBody::class.java))
    }

    // ---- Multiple queries in one file ----

    fun testMultipleQueriesInFile() {
        val file = parseText("""
            define
            entity person sub entity, owns name;
            attribute name sub attribute, value string;

            match
            ${'$'}p isa person;
            select ${'$'}p;
        """.trimIndent())
        assertNoErrors(file)
        val define = PsiTreeUtil.findChildOfType(file, TypeQLDefineQuery::class.java)
        assertNotNull("Expected a define_query", define)
        val pipeline = PsiTreeUtil.findChildOfType(file, TypeQLPipelineQuery::class.java)
        assertNotNull("Expected a pipeline_query", pipeline)
    }

    // ---- Nested fetch ----

    fun testNestedFetchObject() {
        val file = parseText("""
            match
            ${'$'}p isa person;
            fetch {
                "info": {
                    "name": ${'$'}p.name
                }
            };
        """.trimIndent())
        assertNoErrors(file)
        val fetchObjects = PsiTreeUtil.findChildrenOfType(file, TypeQLFetchObject::class.java)
        assertEquals("Expected 2 fetch objects (outer + inner)", 2, fetchObjects.size)
    }

    // ---- Fetch with list ----

    fun testFetchWithList() {
        val file = parseText("""
            match
            ${'$'}p isa person;
            fetch {
                "friends": [${'$'}p.name]
            };
        """.trimIndent())
        assertNoErrors(file)
        assertNotNull(PsiTreeUtil.findChildOfType(file, TypeQLFetchList::class.java))
    }

    // ---- List expressions ----

    fun testListExpressionNew() {
        val file = parseText("""
            match
            ${'$'}x isa attribute;
            let ${'$'}y = [${'$'}x, ${'$'}x];
        """.trimIndent())
        assertNoErrors(file)
        assertNotNull(PsiTreeUtil.findChildOfType(file, TypeQLExpressionListNew::class.java))
    }

    // ---- Preamble with ----

    fun testPreambleWith() {
        val file = parseText("""
            with fun helper(${'$'}a: person) -> string:
                match
                ${'$'}a has name ${'$'}n;
                return first ${'$'}n;
            match
            ${'$'}p isa person;
            let ${'$'}result = helper(${'$'}p);
        """.trimIndent())
        assertNoErrors(file)
        assertNotNull(PsiTreeUtil.findChildOfType(file, TypeQLPreamble::class.java))
    }

    // ---- Signed annotation args ----

    fun testAnnotationWithSignedArgs() {
        val file = parseText("""
            define
            attribute score sub attribute, value double @range(-1.5..2.5);
        """.trimIndent())
        assertNoErrors(file)
        val ann = PsiTreeUtil.findChildOfType(file, TypeQLAnnotationWithArgs::class.java)
        assertNotNull("Expected annotation with args", ann)
    }

    // ---- Links constraint ----

    fun testLinksConstraint() {
        val file = parseText("""
            match
            ${'$'}f isa friendship;
            ${'$'}f links (friend: ${'$'}a, friend: ${'$'}b);
        """.trimIndent())
        assertNoErrors(file)
        val links = PsiTreeUtil.findChildOfType(file, TypeQLLinksConstraint::class.java)
        assertNotNull("Expected a links constraint", links)
        val rolePlayers = PsiTreeUtil.findChildrenOfType(file, TypeQLRolePlayer::class.java)
        assertEquals(2, rolePlayers.size)
    }

    // ---- Comparison statement ----

    fun testComparisonStatement() {
        val file = parseText("""
            match
            ${'$'}p isa person, has age ${'$'}a;
            ${'$'}a > 18;
        """.trimIndent())
        assertNoErrors(file)
        val comp = PsiTreeUtil.findChildOfType(file, TypeQLComparison::class.java)
        assertNotNull("Expected a comparison", comp)
    }

    // ---- List index and subrange ----

    fun testListIndex() {
        val file = parseText("""
            match
            ${'$'}x isa attribute;
            let ${'$'}y = ${'$'}x[0];
        """.trimIndent())
        assertNoErrors(file)
        assertNotNull(PsiTreeUtil.findChildOfType(file, TypeQLExpressionListIndex::class.java))
    }

    fun testListSubrange() {
        val file = parseText("""
            match
            ${'$'}x isa attribute;
            let ${'$'}y = ${'$'}x[0..5];
        """.trimIndent())
        assertNoErrors(file)
        assertNotNull(PsiTreeUtil.findChildOfType(file, TypeQLExpressionListSubrange::class.java))
    }

    // ---- Plain delete ----

    fun testDeletePlain() {
        val file = parseText("""
            match
            ${'$'}p isa person, has name ${'$'}n;
            delete
            has ${'$'}n of ${'$'}p;
        """.trimIndent())
        assertNoErrors(file)
        assertNotNull(PsiTreeUtil.findChildOfType(file, TypeQLDeleteClause::class.java))
        assertNotNull(PsiTreeUtil.findChildOfType(file, TypeQLStatementDeletable::class.java))
    }

    // ---- Empty file ----

    fun testEmptyFile() {
        val file = parseText("")
        assertNoErrors(file)
    }

    // ---- Comment only ----

    fun testCommentOnlyFile() {
        val file = parseText("# This is a comment")
        assertNoErrors(file)
    }

    // ---- Role player without explicit role ----

    fun testRolePlayerWithoutRole() {
        val file = parseText("""
            match
            ${'$'}f isa friendship, links (${'$'}a, ${'$'}b);
        """.trimIndent())
        assertNoErrors(file)
        val rolePlayers = PsiTreeUtil.findChildrenOfType(file, TypeQLRolePlayer::class.java)
        assertEquals(2, rolePlayers.size)
    }

    // ---- Undefine annotation from ----

    fun testUndefineAnnotationFrom() {
        val file = parseText("""
            undefine
            @key from person owns name;
        """.trimIndent())
        assertNoErrors(file)
        val undefine = PsiTreeUtil.findChildOfType(file, TypeQLUndefineQuery::class.java)
        assertNotNull("Expected an undefine_query", undefine)
        val annFrom = PsiTreeUtil.findChildOfType(undefine, TypeQLUndefineAnnotationFrom::class.java)
        assertNotNull("Expected undefine_annotation_from", annFrom)
    }
}
