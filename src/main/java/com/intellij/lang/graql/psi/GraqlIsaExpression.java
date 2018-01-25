// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graql.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GraqlIsaExpression extends PsiElement {

  @Nullable
  GraqlHasValueExpression getHasValueExpression();

  @NotNull
  List<GraqlRelationField> getRelationFieldList();

  @NotNull
  List<GraqlVarField> getVarFieldList();

  @NotNull
  List<GraqlIdentifierExpr> getIdentifierExprList();

}
