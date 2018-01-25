// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graql.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GraqlExpression extends PsiElement {

  @Nullable
  GraqlAttributeExpression getAttributeExpression();

  @Nullable
  GraqlCommitExpression getCommitExpression();

  @Nullable
  GraqlEqualityExpression getEqualityExpression();

  @Nullable
  GraqlHasExpression getHasExpression();

  @Nullable
  GraqlHasValueExpression getHasValueExpression();

  @Nullable
  GraqlIsaExpression getIsaExpression();

  @Nullable
  GraqlKeyExpression getKeyExpression();

  @Nullable
  GraqlLabelExpression getLabelExpression();

  @Nullable
  GraqlPlaysExpression getPlaysExpression();

  @Nullable
  GraqlRelatesExpression getRelatesExpression();

  @Nullable
  GraqlRelationExpression getRelationExpression();

  @Nullable
  GraqlRuleExpression getRuleExpression();

  @Nullable
  GraqlSubExpression getSubExpression();

}
