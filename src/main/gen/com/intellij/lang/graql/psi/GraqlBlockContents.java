// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graql.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GraqlBlockContents extends PsiElement {

  @NotNull
  List<GraqlEscapedExpression> getEscapedExpressionList();

  @NotNull
  List<GraqlPatterns> getPatternsList();

  @NotNull
  List<GraqlQuery> getQueryList();

  @NotNull
  List<GraqlStatement> getStatementList();

}
