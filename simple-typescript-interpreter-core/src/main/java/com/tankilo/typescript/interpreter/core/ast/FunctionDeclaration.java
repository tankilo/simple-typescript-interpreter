package com.tankilo.typescript.interpreter.core.ast;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
public class FunctionDeclaration extends FunctionBase {
    private Identifier id;

    public Identifier getId() {
        return id;
    }

    public void setId(Identifier id) {
        this.id = id;
    }
}
