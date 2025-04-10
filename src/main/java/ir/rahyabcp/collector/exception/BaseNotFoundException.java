package ir.rahyabcp.collector.exception;

public abstract class BaseNotFoundException extends BaseException {

    public BaseNotFoundException(String message) {
        super(message);
    }

    public BaseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
