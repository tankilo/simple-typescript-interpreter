package com.tankilo.babel.traverser.ast;

public class BooleanLiteral extends Literal {
    private boolean value;

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}
