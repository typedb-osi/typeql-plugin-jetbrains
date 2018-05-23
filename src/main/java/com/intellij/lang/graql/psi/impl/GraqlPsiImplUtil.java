package com.intellij.lang.graql.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.lang.graql.GraqlFileType;
import com.intellij.lang.graql.psi.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author github.com/BFergerson
 */
public class GraqlPsiImplUtil {

    public static boolean isIdIdentifier(GraqlIdentifier identifier) {
        PsiFile psiFile = identifier.getContainingFile();
        PsiElement previousElement = psiFile.findElementAt(identifier.getTextRange().getStartOffset() - 1);
        while (previousElement != null) {
            if (previousElement instanceof PsiWhiteSpace) {
                previousElement = psiFile.findElementAt(previousElement.getTextRange().getStartOffset() - 1);
            } else {
                switch (previousElement.getText()) {
                    case "id":
                        return true;
                }
                break;
            }
        }
        return false;
    }

    @Nullable
    public static String determineUsageType(GraqlIdentifier identifier) {
        PsiFile psiFile = identifier.getContainingFile();
        PsiElement previousElement = psiFile.findElementAt(identifier.getTextRange().getStartOffset() - 1);
        while (previousElement != null) {
            if (previousElement instanceof PsiWhiteSpace) {
                previousElement = psiFile.findElementAt(previousElement.getTextRange().getStartOffset() - 1);
            } else {
                switch (previousElement.getText()) {
                    case "plays":
                        return "plays";
                    case "relates":
                        return "relates";
                    case "has":
                        return "has";
                    default:
                        return null;
                }
            }
        }
        return null;
    }

    @Nullable
    public static String determineDeclarationType(GraqlIdentifier identifier) {
        PsiFile psiFile = identifier.getContainingFile();
        PsiElement nextElement = psiFile.findElementAt(identifier.getTextRange().getEndOffset() + 1);
        while (nextElement != null) {
            if (nextElement instanceof PsiWhiteSpace) {
                nextElement = psiFile.findElementAt(nextElement.getTextRange().getEndOffset() + 1);
            } else {
                switch (nextElement.getText()) {
                    case "is-abstract":
                    case "sub":
                        nextElement = psiFile.findElementAt(nextElement.getTextRange().getEndOffset() + 1);
                        break;
                    case "entity":
                        return "entity";
                    case "relationship":
                        return "relationship";
                    case "role":
                        return "role";
                    case "attribute":
                        return "attribute";
                    default:
                        GraqlIdentifier innerDeclaration = findDeclaration(nextElement.getProject(), nextElement.getText());
                        if (innerDeclaration == null) {
                            return null;
                        } else {
                            return determineDeclarationType(innerDeclaration);
                        }
                }
            }
        }
        return null;
    }

    @Nullable
    public static GraqlIdentifier findDeclaration(Project project, String name) {
        List<GraqlIdentifier> declarations = findDeclarations(project, name);
        if (declarations.isEmpty()) {
            return null;
        } else {
            return declarations.get(0);
        }
    }

    @NotNull
    public static List<GraqlIdentifier> findDeclarations(Project project, String name) {
        List<GraqlIdentifier> declarations = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(GraqlFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            GraqlFile graqlFile = (GraqlFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (graqlFile != null) {
                Collection<GraqlIdentifier> identifiers = PsiTreeUtil.collectElementsOfType(
                        graqlFile, GraqlIdentifier.class);
                for (GraqlIdentifier identifier : identifiers) {
                    if (name.equals(identifier.getName())) {
                        boolean isUsage = false;
                        PsiFile psiFile = identifier.getContainingFile();
                        PsiElement nextElement = psiFile.findElementAt(identifier.getTextRange().getEndOffset() + 1);
                        while (nextElement != null) {
                            if (nextElement instanceof PsiWhiteSpace) {
                                nextElement = psiFile.findElementAt(nextElement.getTextRange().getEndOffset() + 1);
                            } else {
                                switch (nextElement.getText()) {
                                    case "is-abstract":
                                        nextElement = psiFile.findElementAt(nextElement.getTextRange().getEndOffset() + 1);
                                        break;
                                    case "sub":
                                        declarations.add(identifier);
                                    default:
                                        isUsage = true;
                                }
                            }
                            if (isUsage) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return declarations;
    }

    public static List<GraqlIdentifier> findUsages(Project project, String name) {
        List<GraqlIdentifier> result = null;
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(GraqlFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            GraqlFile graqlFile = (GraqlFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (graqlFile != null) {
                Collection<GraqlIdentifier> identifiers = PsiTreeUtil.collectElementsOfType(
                        graqlFile, GraqlIdentifier.class);
                for (GraqlIdentifier identifier : identifiers) {
                    if (name.equals(identifier.getName())) {
                        if (result == null) {
                            result = new ArrayList<>();
                        }

                        boolean isUsage = false;
                        boolean isDeclaration = false;
                        PsiFile psiFile = identifier.getContainingFile();
                        PsiElement nextElement = psiFile.findElementAt(identifier.getTextRange().getEndOffset() + 1);
                        while (nextElement != null) {
                            if (nextElement instanceof PsiWhiteSpace) {
                                nextElement = psiFile.findElementAt(nextElement.getTextRange().getEndOffset() + 1);
                            } else {
                                switch (nextElement.getText()) {
                                    case "is-abstract":
                                        nextElement = psiFile.findElementAt(nextElement.getTextRange().getEndOffset() + 1);
                                        break;
                                    case "sub":
                                        isDeclaration = true;
                                        break;
                                    default:
                                        isUsage = true;
                                        result.add(identifier);
                                        break;
                                }
                            }
                            if (isDeclaration || isUsage) {
                                break;
                            }
                        }
                        if (nextElement == null) {
                            result.add(identifier); //reached end of file; is usage
                        }
                    }
                }
            }
        }
        return result != null ? result : Collections.emptyList();
    }

    public static List<GraqlIdentifier> findIdentifiers(Project project) {
        List<GraqlIdentifier> result = null;
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(GraqlFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            GraqlFile graqlFile = (GraqlFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (graqlFile != null) {
                Collection<GraqlIdentifier> identifiers = PsiTreeUtil.collectElementsOfType(
                        graqlFile, GraqlIdentifier.class);
                for (GraqlIdentifier identifier : identifiers) {
                    if (result == null) {
                        result = new ArrayList<>();
                    }
                    result.add(identifier);
                }
            }
        }
        return result != null ? result : Collections.emptyList();
    }

    @Contract(pure = true)
    public static String getName(GraqlIdentifier element) {
        return element.getText();
    }

    public static PsiElement setName(GraqlIdentifier element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(GraqlTokenTypes.IDENTIFIER);
        if (keyNode == null) {
            keyNode = element.getNode().findChildByType(GraqlTokenTypes.STRING_LITERAL);
        }
        if (keyNode != null) {
            GraqlIdentifier property = GraqlElementFactory.createIdentifier(element.getProject(), newName);
            ASTNode newKeyNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(keyNode, newKeyNode);
        }
        return element;
    }

    @Nullable
    public static PsiElement getNameIdentifier(GraqlIdentifier element) {
        if (GraqlTokenTypeSets.FULL_KEYWORD_SET.contains(element.getText())) {
            return null;
        } else {
            return element;
        }
    }
}
