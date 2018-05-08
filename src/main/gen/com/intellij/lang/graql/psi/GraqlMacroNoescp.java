// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graql.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GraqlMacroNoescp extends PsiElement {

  @Nullable
  GraqlAccessor getAccessor();

  @NotNull
  List<GraqlExpression> getExpressionList();

  @Nullable
  GraqlIdentifier getIdentifier();

}
