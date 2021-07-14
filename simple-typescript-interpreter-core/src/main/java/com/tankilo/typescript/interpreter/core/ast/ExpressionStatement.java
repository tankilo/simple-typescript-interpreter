package com.tankilo.typescript.interpreter.core.ast;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
public class ExpressionStatement extends Statement {
    private Expression expression;

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
}
