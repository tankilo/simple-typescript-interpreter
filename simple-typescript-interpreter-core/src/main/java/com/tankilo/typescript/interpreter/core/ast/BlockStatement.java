package com.tankilo.typescript.interpreter.core.ast;

import java.util.List;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
public class BlockStatement  extends Statement {
    private List<Statement> body;

    public List<Statement> getBody() {
        return body;
    }

    public void setBody(List<Statement> body) {
        this.body = body;
    }
}
