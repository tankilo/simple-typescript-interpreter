package com.tankilo.typescript.interpreter.core;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
public class InterpreterException extends BaseInterpreterException {
    public InterpreterException(String message) {
        super(message);
    }

    public InterpreterException(String message, Throwable cause) {
        super(message, cause);
    }
}
