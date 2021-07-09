package com.tankilo.typescript.interpreter.ast;

public class WhileStatement extends Statement {
    private Expression test;
    private Statement body;

    public Expression getTest() {
        return test;
    }

    public void setTest(Expression test) {
        this.test = test;
    }

    public Statement getBody() {
        return body;
    }

    public void setBody(Statement body) {
        this.body = body;
    }
}
