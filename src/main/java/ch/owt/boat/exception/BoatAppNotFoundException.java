package ch.owt.boat.exception;

public class BoatAppNotFoundException extends RuntimeException {

    public BoatAppNotFoundException(String message) {
        super(message);
    }

    public BoatAppNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BoatAppNotFoundException(Throwable cause) {
        super(cause);
    }
}
