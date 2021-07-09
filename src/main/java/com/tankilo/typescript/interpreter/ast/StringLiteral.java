package com.tankilo.typescript.interpreter.ast;

public class StringLiteral extends Literal {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
