// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graql.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.intellij.lang.graql.psi.GraqlTokenTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.graql.psi.*;

public class GraqlQueryImpl extends ASTWrapperPsiElement implements GraqlQuery {

  public GraqlQueryImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GraqlVisitor visitor) {
    visitor.visitQuery(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GraqlVisitor) accept((GraqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GraqlAggregateQuery getAggregateQuery() {
    return findChildByClass(GraqlAggregateQuery.class);
  }

  @Override
  @Nullable
  public GraqlDefineQuery getDefineQuery() {
    return findChildByClass(GraqlDefineQuery.class);
  }

  @Override
  @Nullable
  public GraqlDeleteQuery getDeleteQuery() {
    return findChildByClass(GraqlDeleteQuery.class);
  }

  @Override
  @Nullable
  public GraqlGetQuery getGetQuery() {
    return findChildByClass(GraqlGetQuery.class);
  }

  @Override
  @Nullable
  public GraqlInsertQuery getInsertQuery() {
    return findChildByClass(GraqlInsertQuery.class);
  }

  @Override
  @Nullable
  public GraqlUndefineQuery getUndefineQuery() {
    return findChildByClass(GraqlUndefineQuery.class);
  }

}
