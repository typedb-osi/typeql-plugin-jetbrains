// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graql.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GraqlBool extends PsiElement {

  @Nullable
  GraqlAndBool getAndBool();

  @NotNull
  List<GraqlExpression> getExpressionList();

  @Nullable
  GraqlGroupBool getGroupBool();

  @Nullable
  GraqlNotBool getNotBool();

  @NotNull
  List<GraqlNumber> getNumberList();

  @Nullable
  GraqlOrBool getOrBool();

  @Nullable
  GraqlUntypedExpression getUntypedExpression();

}
