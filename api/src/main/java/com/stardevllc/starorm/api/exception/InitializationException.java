package com.stardevllc.starorm.api.exception;

public class InitializationException extends RuntimeException {
    public InitializationException(String message) {
        super(message);
    }
    
    public InitializationException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public InitializationException(Throwable cause) {
        super(cause);
    }
    
    public InitializationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public InitializationException() {
    }
}
