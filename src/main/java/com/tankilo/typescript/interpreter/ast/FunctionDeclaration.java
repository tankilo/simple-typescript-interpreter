package com.tankilo.typescript.interpreter.ast;

public class FunctionDeclaration extends FunctionBase {
    private Identifier id;

    public Identifier getId() {
        return id;
    }

    public void setId(Identifier id) {
        this.id = id;
    }
}
