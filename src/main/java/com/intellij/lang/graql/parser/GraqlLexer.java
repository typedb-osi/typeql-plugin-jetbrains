package com.intellij.lang.graql.parser;

import com.intellij.lang.graql.psi.GraqlTokenTypes;
import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.LookAheadLexer;

/**
 * @author github.com/BFergerson
 */
public class GraqlLexer extends LookAheadLexer implements GraqlTokenTypes {

    public GraqlLexer() {
        super(new FlexAdapter(new _GraqlLexer()));
    }

}