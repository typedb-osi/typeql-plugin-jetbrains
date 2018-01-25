// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graql.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GraqlLabelExpression extends PsiElement {

  @Nullable
  GraqlRelationField getRelationField();

  @Nullable
  GraqlVarField getVarField();

  @Nullable
  GraqlIdentifierExpr getIdentifierExpr();

  @NotNull
  PsiElement getStringLiteral();

}
