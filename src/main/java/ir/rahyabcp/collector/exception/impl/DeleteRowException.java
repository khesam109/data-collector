package ir.rahyabcp.collector.exception.impl;

import ir.rahyabcp.collector.exception.BaseInvalidDatabaseOperationException;

public final class DeleteRowException extends BaseInvalidDatabaseOperationException {

    public DeleteRowException(String message) {
        super(message);
    }
}
