package com.tankilo.typescript.interpreter.core.ast;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
public class IfStatement extends Statement {
    private Expression test;
    private Statement consequent;
    private Statement alternate;

    public Expression getTest() {
        return test;
    }

    public void setTest(Expression test) {
        this.test = test;
    }

    public Statement getConsequent() {
        return consequent;
    }

    public void setConsequent(Statement consequent) {
        this.consequent = consequent;
    }

    public Statement getAlternate() {
        return alternate;
    }

    public void setAlternate(Statement alternate) {
        this.alternate = alternate;
    }
}
