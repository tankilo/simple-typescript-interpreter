package com.tankilo.typescript.interpreter.core.ast;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
public class StringLiteral extends Literal {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
