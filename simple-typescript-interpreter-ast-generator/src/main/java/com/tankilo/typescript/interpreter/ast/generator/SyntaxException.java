package com.tankilo.typescript.interpreter.ast.generator;

import com.tankilo.typescript.interpreter.core.BaseInterpreterException;

public class SyntaxException extends BaseInterpreterException {
    public SyntaxException(String message) {
        super(message);
    }
}
