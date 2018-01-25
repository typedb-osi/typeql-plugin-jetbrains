// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graql.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GraqlSubExpression extends PsiElement {

  @Nullable
  GraqlDatatypeExpression getDatatypeExpression();

  @Nullable
  GraqlRelationField getRelationField();

  @NotNull
  List<GraqlSubExpressions> getSubExpressionsList();

  @Nullable
  GraqlVarField getVarField();

  @Nullable
  GraqlIdentifierExpr getIdentifierExpr();

  @Nullable
  GraqlThingExpr getThingExpr();

}
