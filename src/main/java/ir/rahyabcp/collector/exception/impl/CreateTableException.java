package ir.rahyabcp.collector.exception.impl;

import ir.rahyabcp.collector.exception.BaseInvalidDatabaseOperationException;

public final class CreateTableException extends BaseInvalidDatabaseOperationException {

    public CreateTableException(String message) {
        super(message);
    }
}
