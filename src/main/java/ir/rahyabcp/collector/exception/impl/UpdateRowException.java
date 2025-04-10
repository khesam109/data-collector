package ir.rahyabcp.collector.exception.impl;

import ir.rahyabcp.collector.exception.BaseInvalidDatabaseOperationException;

public final class UpdateRowException extends BaseInvalidDatabaseOperationException {

    public UpdateRowException(String message) {
        super(message);
    }
}
