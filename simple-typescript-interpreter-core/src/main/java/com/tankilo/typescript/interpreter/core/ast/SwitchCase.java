package com.tankilo.typescript.interpreter.core.ast;

import java.util.List;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
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
