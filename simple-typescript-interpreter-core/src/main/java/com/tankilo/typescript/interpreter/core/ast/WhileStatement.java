package com.tankilo.typescript.interpreter.core.ast;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
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
