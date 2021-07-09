package com.tankilo.typescript.interpreter.ast;

public class TSTypeReference extends TsType {
    private Identifier typeName;

    public Identifier getTypeName() {
        return typeName;
    }

    public void setTypeName(Identifier typeName) {
        this.typeName = typeName;
    }
}
