package com.tankilo.typescript.interpreter.ast;

public class ObjectProperty extends ObjectMemberBase {
    private boolean shorthand;
    private Expression value;

    public boolean isShorthand() {
        return shorthand;
    }

    public void setShorthand(boolean shorthand) {
        this.shorthand = shorthand;
    }

    public Expression getValue() {
        return value;
    }

    public void setValue(Expression value) {
        this.value = value;
    }
}
