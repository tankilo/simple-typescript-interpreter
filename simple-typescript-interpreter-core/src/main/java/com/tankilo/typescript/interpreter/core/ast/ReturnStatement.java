package com.tankilo.typescript.interpreter.core.ast;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
public class ReturnStatement extends Statement {
    private Expression argument;

    public Expression getArgument() {
        return argument;
    }

    public void setArgument(Expression argument) {
        this.argument = argument;
    }
}
