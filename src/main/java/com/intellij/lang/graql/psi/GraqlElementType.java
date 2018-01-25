package com.intellij.lang.graql.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.lang.graql.GraqlLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * todo: description
 *
 * @author github.com/BFergerson
 */
public class GraqlElementType extends IElementType {

    public GraqlElementType(@NotNull @NonNls String debugName) {
        super(debugName, GraqlLanguage.INSTANCE);
    }

}