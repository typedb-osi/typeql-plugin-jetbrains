// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graql.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GraqlHasValueExpression extends PsiElement {

  @NotNull
  List<GraqlVarField> getVarFieldList();

  @NotNull
  List<GraqlIdentifierExpr> getIdentifierExprList();

  @Nullable
  GraqlLiteralExpr getLiteralExpr();

}
