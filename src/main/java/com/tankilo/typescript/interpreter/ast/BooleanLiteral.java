package com.tankilo.typescript.interpreter.ast;

public class BooleanLiteral extends Literal {
    private boolean value;

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}
