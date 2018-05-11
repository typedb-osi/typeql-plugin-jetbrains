// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graql.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GraqlAggregate extends PsiElement {

  @NotNull
  List<GraqlArgument> getArgumentList();

  @Nullable
  GraqlLabelOrVar getLabelOrVar();

  @NotNull
  List<GraqlNamedAgg> getNamedAggList();

}
