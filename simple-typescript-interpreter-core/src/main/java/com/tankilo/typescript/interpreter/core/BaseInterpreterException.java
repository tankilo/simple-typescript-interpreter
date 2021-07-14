package com.tankilo.typescript.interpreter.core;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
public abstract class BaseInterpreterException extends Exception {
    public BaseInterpreterException(String message) {
        super(message);
    }

    public BaseInterpreterException(String message, Throwable cause) {
        super(message, cause);
    }
}
