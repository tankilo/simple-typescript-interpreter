package com.tankilo.typescript.interpreter.core.ast;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
public class VariableDeclarator extends Node {
    private Pattern id;
    private Expression init;

    public Pattern getId() {
        return id;
    }

    public void setId(Pattern id) {
        this.id = id;
    }

    public Expression getInit() {
        return init;
    }

    public void setInit(Expression init) {
        this.init = init;
    }
}
