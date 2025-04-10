package ir.rahyabcp.collector.exception;

public abstract class BaseInvalidDatabaseOperationException extends BaseInvalidOperationException {

    public BaseInvalidDatabaseOperationException(String message) {
        super(message);
    }

    public BaseInvalidDatabaseOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
