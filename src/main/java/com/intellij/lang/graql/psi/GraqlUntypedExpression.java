// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graql.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GraqlUntypedExpression extends PsiElement {

  @Nullable
  GraqlIdMacro getIdMacro();

  @Nullable
  GraqlMacroEquals getMacroEquals();

  @Nullable
  GraqlMacroNoescp getMacroNoescp();

  @NotNull
  List<GraqlAccessor> getAccessorList();

  @NotNull
  List<GraqlExpression> getExpressionList();

  @Nullable
  GraqlId getId();

}
