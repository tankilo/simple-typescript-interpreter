package com.tankilo.babel.traverser.ast;

import java.util.List;

public class Program {
    private String type;

    private List<Statement> body;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Statement> getBody() {
        return body;
    }

    public void setBody(List<Statement> body) {
        this.body = body;
    }
}
