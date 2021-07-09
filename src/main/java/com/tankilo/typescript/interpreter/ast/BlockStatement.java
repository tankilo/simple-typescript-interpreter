package com.tankilo.typescript.interpreter.ast;

import java.util.List;

public class BlockStatement  extends Statement {
    private List<Statement> body;

    public List<Statement> getBody() {
        return body;
    }

    public void setBody(List<Statement> body) {
        this.body = body;
    }
}
