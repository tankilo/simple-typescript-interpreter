package com.tankilo.typescript.interpreter.core.ast;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
public class TSTypeReference extends TsType {
    private Identifier typeName;

    public Identifier getTypeName() {
        return typeName;
    }

    public void setTypeName(Identifier typeName) {
        this.typeName = typeName;
    }
}
