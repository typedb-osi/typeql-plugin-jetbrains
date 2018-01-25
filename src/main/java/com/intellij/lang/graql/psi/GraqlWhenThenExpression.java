// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graql.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GraqlWhenThenExpression extends PsiElement {

  @NotNull
  List<GraqlIsaExpression> getIsaExpressionList();

  @NotNull
  List<GraqlRelationStatement> getRelationStatementList();

}
