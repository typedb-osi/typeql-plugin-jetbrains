// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graql.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GraqlInsertQuery extends PsiElement {

  @Nullable
  GraqlBlockContents getBlockContents();

  @Nullable
  GraqlLabelOrVar getLabelOrVar();

  @Nullable
  GraqlMatchPart getMatchPart();

  @Nullable
  GraqlVarPatterns getVarPatterns();

}
