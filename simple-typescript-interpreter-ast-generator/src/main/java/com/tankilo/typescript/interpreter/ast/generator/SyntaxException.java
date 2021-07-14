package com.tankilo.typescript.interpreter.ast.generator;

import com.tankilo.typescript.interpreter.core.BaseInterpreterException;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
public class SyntaxException extends BaseInterpreterException {
    public SyntaxException(String message) {
        super(message);
    }
}
