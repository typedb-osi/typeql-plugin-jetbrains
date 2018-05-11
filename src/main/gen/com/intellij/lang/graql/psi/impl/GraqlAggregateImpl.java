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

public class GraqlAggregateImpl extends ASTWrapperPsiElement implements GraqlAggregate {

  public GraqlAggregateImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GraqlVisitor visitor) {
    visitor.visitAggregate(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GraqlVisitor) accept((GraqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<GraqlArgument> getArgumentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GraqlArgument.class);
  }

  @Override
  @Nullable
  public GraqlLabelOrVar getLabelOrVar() {
    return findChildByClass(GraqlLabelOrVar.class);
  }

  @Override
  @NotNull
  public List<GraqlNamedAgg> getNamedAggList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GraqlNamedAgg.class);
  }

}
