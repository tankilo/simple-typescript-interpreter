package com.tankilo.babel.traverser.ast;

public class BooleanLiteral extends Literal {
    private Boolean value;

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }
}
