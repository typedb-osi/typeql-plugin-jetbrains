// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graql.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GraqlProperty extends PsiElement {

  @NotNull
  List<GraqlCasting> getCastingList();

  @Nullable
  GraqlEscapedExpression getEscapedExpression();

  @Nullable
  GraqlId getId();

  @Nullable
  GraqlLabel getLabel();

  @Nullable
  GraqlPatterns getPatterns();

  @Nullable
  GraqlPredicate getPredicate();

  @Nullable
  GraqlProperty getProperty();

  @Nullable
  GraqlVarPatterns getVarPatterns();

  @Nullable
  GraqlVariable getVariable();

  @Nullable
  PsiElement getRegex();

}
