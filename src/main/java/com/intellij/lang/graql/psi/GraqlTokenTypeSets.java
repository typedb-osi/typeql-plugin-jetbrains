package com.intellij.lang.graql.psi;

import com.intellij.lang.graql.GraqlLanguage;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;

/**
 * @author github.com/BFergerson
 */
public interface GraqlTokenTypeSets extends GraqlTokenTypes {

    IFileElementType GRAQL_FILE = new IFileElementType("GRAQLFILE", GraqlLanguage.INSTANCE);

    TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    TokenSet COMMENTS = TokenSet.create(SINGLE_LINE_COMMENT);
    TokenSet DATATYPES = TokenSet.create(DOUBLE, LONG, STRING, DATE, BOOLEAN);
    TokenSet MODEL = TokenSet.create(ENTITY, RELATIONSHIP, ROLE, ATTRIBUTE);
    TokenSet KEYWORDS = TokenSet.create(DEFINE, INSERT, MATCH, SUB, RELATES, KEY, HAS, PLAYS, DATATYPE,
            ISA, COMMIT, GET, RULE, WHEN, THEN, COMPUTE, CLUSTER, IN, MEMBER, IS_ABSTRACT, AS,
            DELETE, ASK, COUNT, SUM, MAX, MIN, MEAN, MEDIAN, GROUP, OF, STD, OR, VAL, CONTAINS, OFFSET, LIMIT, ORDER);

}