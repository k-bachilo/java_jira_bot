package dev.app.exception;

public class GlobalBusinessException extends RuntimeException {
    public GlobalBusinessException() {
    }

    public GlobalBusinessException(String message) {
        super(message);
    }

    public GlobalBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public GlobalBusinessException(Throwable cause) {
        super(cause);
    }

    public GlobalBusinessException(String message, Throwable cause,
                                 boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
