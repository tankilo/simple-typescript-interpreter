package com.tankilo.babel.traverser.ast;

import java.util.List;

public class SwitchStatement extends Statement {
    private Expression discriminant;
    private List<SwitchCase> cases;

    public Expression getDiscriminant() {
        return discriminant;
    }

    public void setDiscriminant(Expression discriminant) {
        this.discriminant = discriminant;
    }

    public List<SwitchCase> getCases() {
        return cases;
    }

    public void setCases(List<SwitchCase> cases) {
        this.cases = cases;
    }
}
