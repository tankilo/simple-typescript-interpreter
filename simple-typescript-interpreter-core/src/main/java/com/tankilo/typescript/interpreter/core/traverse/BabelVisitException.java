package com.tankilo.typescript.interpreter.core.traverse;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
public class BabelVisitException extends RuntimeException {
    public BabelVisitException() {
    }

    public BabelVisitException(String message) {
        super(message);
    }

    public BabelVisitException(String message, Throwable cause) {
        super(message, cause);
    }

    public BabelVisitException(Throwable cause) {
        super(cause);
    }

    public BabelVisitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
