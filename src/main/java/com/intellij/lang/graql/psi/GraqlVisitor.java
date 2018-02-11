// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graql.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class GraqlVisitor extends PsiElementVisitor {

  public void visitAggregate(@NotNull GraqlAggregate o) {
    visitPsiElement(o);
  }

  public void visitAggregateQuery(@NotNull GraqlAggregateQuery o) {
    visitPsiElement(o);
  }

  public void visitAndPattern(@NotNull GraqlAndPattern o) {
    visitPattern(o);
  }

  public void visitArgument(@NotNull GraqlArgument o) {
    visitPsiElement(o);
  }

  public void visitCasting(@NotNull GraqlCasting o) {
    visitPsiElement(o);
  }

  public void visitClusterParam(@NotNull GraqlClusterParam o) {
    visitPsiElement(o);
  }

  public void visitDefineQuery(@NotNull GraqlDefineQuery o) {
    visitPsiElement(o);
  }

  public void visitDeleteQuery(@NotNull GraqlDeleteQuery o) {
    visitPsiElement(o);
  }

  public void visitGetQuery(@NotNull GraqlGetQuery o) {
    visitPsiElement(o);
  }

  public void visitId(@NotNull GraqlId o) {
    visitPsiElement(o);
  }

  public void visitIdentifier(@NotNull GraqlIdentifier o) {
    visitNamedElement(o);
  }

  public void visitInList(@NotNull GraqlInList o) {
    visitPsiElement(o);
  }

  public void visitInsertQuery(@NotNull GraqlInsertQuery o) {
    visitPsiElement(o);
  }

  public void visitLabel(@NotNull GraqlLabel o) {
    visitPsiElement(o);
  }

  public void visitLabelList(@NotNull GraqlLabelList o) {
    visitPsiElement(o);
  }

  public void visitMatchLimit(@NotNull GraqlMatchLimit o) {
    visitPsiElement(o);
  }

  public void visitMatchLimitOffset(@NotNull GraqlMatchLimitOffset o) {
    visitPsiElement(o);
  }

  public void visitMatchOffset(@NotNull GraqlMatchOffset o) {
    visitPsiElement(o);
  }

  public void visitMatchOffsetLimit(@NotNull GraqlMatchOffsetLimit o) {
    visitPsiElement(o);
  }

  public void visitMatchOrderBy(@NotNull GraqlMatchOrderBy o) {
    visitPsiElement(o);
  }

  public void visitMatchPart(@NotNull GraqlMatchPart o) {
    visitPsiElement(o);
  }

  public void visitNamedAgg(@NotNull GraqlNamedAgg o) {
    visitPsiElement(o);
  }

  public void visitOfList(@NotNull GraqlOfList o) {
    visitPsiElement(o);
  }

  public void visitOrPattern(@NotNull GraqlOrPattern o) {
    visitPattern(o);
  }

  public void visitPattern(@NotNull GraqlPattern o) {
    visitPsiElement(o);
  }

  public void visitPatterns(@NotNull GraqlPatterns o) {
    visitPsiElement(o);
  }

  public void visitPredicate(@NotNull GraqlPredicate o) {
    visitPsiElement(o);
  }

  public void visitProperty(@NotNull GraqlProperty o) {
    visitPsiElement(o);
  }

  public void visitQuery(@NotNull GraqlQuery o) {
    visitPsiElement(o);
  }

  public void visitUndefineQuery(@NotNull GraqlUndefineQuery o) {
    visitPsiElement(o);
  }

  public void visitValue(@NotNull GraqlValue o) {
    visitPsiElement(o);
  }

  public void visitValueOrVar(@NotNull GraqlValueOrVar o) {
    visitPsiElement(o);
  }

  public void visitVarPattern(@NotNull GraqlVarPattern o) {
    visitPattern(o);
  }

  public void visitVarPatterns(@NotNull GraqlVarPatterns o) {
    visitPsiElement(o);
  }

  public void visitVariable(@NotNull GraqlVariable o) {
    visitPsiElement(o);
  }

  public void visitVariables(@NotNull GraqlVariables o) {
    visitPsiElement(o);
  }

  public void visitNamedElement(@NotNull GraqlNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
