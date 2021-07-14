package com.tankilo.typescript.interpreter.core.ast;

import java.util.List;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
public abstract class FunctionBase extends Statement {

    private BlockStatement body;
    private List<Pattern> params;
    private TypeAnnotationBase returnType;

    public BlockStatement getBody() {
        return body;
    }

    public void setBody(BlockStatement body) {
        this.body = body;
    }

    public List<Pattern> getParams() {
        return params;
    }

    public void setParams(List<Pattern> params) {
        this.params = params;
    }

    public TypeAnnotationBase getReturnType() {
        return returnType;
    }

    public void setReturnType(TypeAnnotationBase returnType) {
        this.returnType = returnType;
    }
}
