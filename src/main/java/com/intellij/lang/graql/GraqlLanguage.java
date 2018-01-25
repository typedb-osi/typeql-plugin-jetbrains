package com.intellij.lang.graql;

import com.intellij.lang.Language;

/**
 * @author github.com/BFergerson
 */
public class GraqlLanguage extends Language {

    public static final GraqlLanguage INSTANCE = new GraqlLanguage();

    private GraqlLanguage() {
        super("Graql");
    }

}
