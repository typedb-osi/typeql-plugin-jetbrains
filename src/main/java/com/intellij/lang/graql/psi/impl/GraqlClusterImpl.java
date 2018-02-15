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

public class GraqlClusterImpl extends ASTWrapperPsiElement implements GraqlCluster {

  public GraqlClusterImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GraqlVisitor visitor) {
    visitor.visitCluster(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GraqlVisitor) accept((GraqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<GraqlClusterParam> getClusterParamList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GraqlClusterParam.class);
  }

  @Override
  @Nullable
  public GraqlId getId() {
    return findChildByClass(GraqlId.class);
  }

  @Override
  @Nullable
  public GraqlInList getInList() {
    return findChildByClass(GraqlInList.class);
  }

}
