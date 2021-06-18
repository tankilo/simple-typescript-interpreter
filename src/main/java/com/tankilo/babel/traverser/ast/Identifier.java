package com.tankilo.babel.traverser.ast;

public class Identifier extends Pattern {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
