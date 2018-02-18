// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graql.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GraqlExpression extends PsiElement {

  @Nullable
  GraqlNil getNil();

  @Nullable
  GraqlNumber getNumber();

  @Nullable
  GraqlUntypedExpression getUntypedExpression();

  @Nullable
  PsiElement getStringLiteral();

}
