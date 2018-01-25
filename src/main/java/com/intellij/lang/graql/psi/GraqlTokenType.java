package com.intellij.lang.graql.psi;

import com.intellij.lang.graql.GraqlLanguage;
import com.intellij.psi.tree.IElementType;

/**
 * @author github.com/BFergerson
 */
public class GraqlTokenType extends IElementType {

    public GraqlTokenType(String debugName) {
        super(debugName, GraqlLanguage.INSTANCE);
    }

}