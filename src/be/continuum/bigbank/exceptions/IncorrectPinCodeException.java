package be.continuum.bigbank.exceptions;

public class IncorrectPinCodeException extends RuntimeException {
    public IncorrectPinCodeException() {
    }

    public IncorrectPinCodeException(String message) {
        super(message);
    }

    public IncorrectPinCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectPinCodeException(Throwable cause) {
        super(cause);
    }

    public IncorrectPinCodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
