package com.intellij.lang.graql.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.lang.graql.GraqlFileType;
import com.intellij.lang.graql.psi.GraqlElementFactory;
import com.intellij.lang.graql.psi.GraqlFile;
import com.intellij.lang.graql.psi.GraqlIdentifierExpr;
import com.intellij.lang.graql.psi.GraqlTokenTypes;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.indexing.FileBasedIndex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author github.com/BFergerson
 */
public class GraqlPsiImplUtil {

    public static List<GraqlIdentifierExpr> findIdentifiers(Project project, String name) {
        List<GraqlIdentifierExpr> result = null;
        Collection<VirtualFile> virtualFiles =
                FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, GraqlFileType.INSTANCE,
                        GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            GraqlFile graqlFile = (GraqlFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (graqlFile != null) {
                Collection<GraqlIdentifierExpr> identifiers = PsiTreeUtil.collectElementsOfType(
                        graqlFile, GraqlIdentifierExpr.class);
                for (GraqlIdentifierExpr identifier : identifiers) {
                    if (name.equals(identifier.getName())) {
                        if (result == null) {
                            result = new ArrayList<>();
                        }
                        result.add(identifier);
                    }
                }
            }
        }
        return result != null ? result : Collections.emptyList();
    }

    public static List<GraqlIdentifierExpr> findIdentifiers(Project project) {
        List<GraqlIdentifierExpr> result = null;
        Collection<VirtualFile> virtualFiles =
                FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, GraqlFileType.INSTANCE,
                        GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            GraqlFile graqlFile = (GraqlFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (graqlFile != null) {
                Collection<GraqlIdentifierExpr> identifiers = PsiTreeUtil.collectElementsOfType(
                        graqlFile, GraqlIdentifierExpr.class);
                for (GraqlIdentifierExpr identifier : identifiers) {
                    if (result == null) {
                        result = new ArrayList<>();
                    }
                    result.add(identifier);
                }
            }
        }
        return result != null ? result : Collections.emptyList();
    }

    public static String getName(GraqlIdentifierExpr element) {
        if (element.getIdentifier() != null) {
            return element.getIdentifier().getText();
        } else if (element.getStringLiteral() != null) {
            return element.getStringLiteral().getText();
        } else {
            throw new IllegalArgumentException("Unknown element: " + element);
        }
    }

    public static PsiElement setName(GraqlIdentifierExpr element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(GraqlTokenTypes.IDENTIFIER);
        if (keyNode == null) {
            keyNode = element.getNode().findChildByType(GraqlTokenTypes.STRING_LITERAL);
        }
        if (keyNode != null) {
            GraqlIdentifierExpr property = GraqlElementFactory.createIdentifier(element.getProject(), newName);
            ASTNode newKeyNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(keyNode, newKeyNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(GraqlIdentifierExpr element) {
        if (element.getIdentifier() != null) {
            return element.getIdentifier();
        } else if (element.getStringLiteral() != null) {
            return element.getStringLiteral();
        } else {
            throw new IllegalArgumentException("Unknown element: " + element);
        }
    }
}
