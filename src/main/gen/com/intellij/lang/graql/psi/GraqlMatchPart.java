// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graql.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GraqlMatchPart extends PsiElement {

  @Nullable
  GraqlBlockContents getBlockContents();

  @Nullable
  GraqlMatchLimitOffset getMatchLimitOffset();

  @Nullable
  GraqlMatchOffsetLimit getMatchOffsetLimit();

  @Nullable
  GraqlMatchOrderBy getMatchOrderBy();

  @NotNull
  GraqlPatterns getPatterns();

}
