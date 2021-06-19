package com.tankilo.babel.traverser.ast;

public class ExpressionStatement extends Statement {
    private Expression expression;

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
}
