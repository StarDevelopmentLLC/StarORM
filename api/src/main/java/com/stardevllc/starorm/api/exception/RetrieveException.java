package com.stardevllc.starorm.api.exception;

public class RetrieveException extends RuntimeException {
    public RetrieveException() {
    }
    
    public RetrieveException(String message) {
        super(message);
    }
    
    public RetrieveException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public RetrieveException(Throwable cause) {
        super(cause);
    }
    
    public RetrieveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
