package be.continuum.bigbank.exceptions;

public class IbanNotFoundException extends RuntimeException {
    public IbanNotFoundException() {
    }

    public IbanNotFoundException(String message) {
        super(message);
    }

    public IbanNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public IbanNotFoundException(Throwable cause) {
        super(cause);
    }

    public IbanNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
