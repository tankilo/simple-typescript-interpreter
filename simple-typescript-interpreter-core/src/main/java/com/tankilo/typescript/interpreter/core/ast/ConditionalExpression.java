package com.tankilo.typescript.interpreter.core.ast;

/**
 * @author Tankilo E-mail: tankilo@126.com
 * A conditional expression, i.e., a ternary ?/: expression.
 */
public class ConditionalExpression extends Node implements Expression {
    private Expression test;
    private Expression alternate;
    private Expression consequent;

    public Expression getTest() {
        return test;
    }

    public void setTest(Expression test) {
        this.test = test;
    }

    public Expression getAlternate() {
        return alternate;
    }

    public void setAlternate(Expression alternate) {
        this.alternate = alternate;
    }

    public Expression getConsequent() {
        return consequent;
    }

    public void setConsequent(Expression consequent) {
        this.consequent = consequent;
    }
}
