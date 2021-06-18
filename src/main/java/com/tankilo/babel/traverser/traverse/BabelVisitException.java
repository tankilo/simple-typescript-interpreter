package com.tankilo.babel.traverser.traverse;

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
