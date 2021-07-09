package com.tankilo.typescript.interpreter.ast;

public class ForInStatement extends Statement {

    private VariableDeclaration left;
    private Expression right;
    private Statement body;

    public VariableDeclaration getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Expression right) {
        this.right = right;
    }

    public Statement getBody() {
        return body;
    }

    public void setBody(Statement body) {
        this.body = body;
    }
}
