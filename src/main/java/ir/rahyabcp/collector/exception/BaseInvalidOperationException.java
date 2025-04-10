package ir.rahyabcp.collector.exception;

public abstract class BaseInvalidOperationException extends BaseException {

    public BaseInvalidOperationException(String message) {
        super(message);
    }

    public BaseInvalidOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
