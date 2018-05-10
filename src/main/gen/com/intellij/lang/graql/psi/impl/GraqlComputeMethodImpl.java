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

public class GraqlComputeMethodImpl extends ASTWrapperPsiElement implements GraqlComputeMethod {

  public GraqlComputeMethodImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GraqlVisitor visitor) {
    visitor.visitComputeMethod(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GraqlVisitor) accept((GraqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GraqlCluster getCluster() {
    return findChildByClass(GraqlCluster.class);
  }

  @Override
  @Nullable
  public GraqlCount getCount() {
    return findChildByClass(GraqlCount.class);
  }

  @Override
  @Nullable
  public GraqlDegrees getDegrees() {
    return findChildByClass(GraqlDegrees.class);
  }

  @Override
  @Nullable
  public GraqlMax getMax() {
    return findChildByClass(GraqlMax.class);
  }

  @Override
  @Nullable
  public GraqlMean getMean() {
    return findChildByClass(GraqlMean.class);
  }

  @Override
  @Nullable
  public GraqlMedian getMedian() {
    return findChildByClass(GraqlMedian.class);
  }

  @Override
  @Nullable
  public GraqlMin getMin() {
    return findChildByClass(GraqlMin.class);
  }

  @Override
  @Nullable
  public GraqlPath getPath() {
    return findChildByClass(GraqlPath.class);
  }

  @Override
  @Nullable
  public GraqlPaths getPaths() {
    return findChildByClass(GraqlPaths.class);
  }

  @Override
  @Nullable
  public GraqlStd getStd() {
    return findChildByClass(GraqlStd.class);
  }

  @Override
  @Nullable
  public GraqlSum getSum() {
    return findChildByClass(GraqlSum.class);
  }

}
