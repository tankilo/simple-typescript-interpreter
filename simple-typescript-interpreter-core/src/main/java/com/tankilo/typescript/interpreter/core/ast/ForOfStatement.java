package com.tankilo.typescript.interpreter.core.ast;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
public class ForOfStatement extends Statement {
    private VariableDeclaration left;
    private Expression right;
    private Statement body;

    public VariableDeclaration getLeft() {
        return left;
    }

    public void setLeft(VariableDeclaration left) {
        this.left = left;
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
