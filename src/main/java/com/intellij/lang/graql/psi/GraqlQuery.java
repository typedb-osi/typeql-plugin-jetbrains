// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graql.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GraqlQuery extends PsiElement {

  @Nullable
  GraqlAggregateQuery getAggregateQuery();

  @Nullable
  GraqlComputeQuery getComputeQuery();

  @Nullable
  GraqlDefineQuery getDefineQuery();

  @Nullable
  GraqlDeleteQuery getDeleteQuery();

  @Nullable
  GraqlGetQuery getGetQuery();

  @Nullable
  GraqlInsertQuery getInsertQuery();

  @Nullable
  GraqlUndefineQuery getUndefineQuery();

}
