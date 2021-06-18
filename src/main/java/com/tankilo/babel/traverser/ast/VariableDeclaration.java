package com.tankilo.babel.traverser.ast;

import java.util.List;

public class VariableDeclaration extends Statement {
    /**
     * "var" | "let" | "const"
     */
    private String kind;
    private List<VariableDeclarator> declarations;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public List<VariableDeclarator> getDeclarations() {
        return declarations;
    }

    public void setDeclarations(List<VariableDeclarator> declarations) {
        this.declarations = declarations;
    }
}
