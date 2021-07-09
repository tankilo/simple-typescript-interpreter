package com.tankilo.typescript.interpreter.ast;

import java.util.List;

public class SwitchCase extends Node {
    private Expression test;
    private List<Statement> consequent;

    public Expression getTest() {
        return test;
    }

    public void setTest(Expression test) {
        this.test = test;
    }

    public List<Statement> getConsequent() {
        return consequent;
    }

    public void setConsequent(List<Statement> consequent) {
        this.consequent = consequent;
    }
}
