package ir.rahyabcp.collector.exception.impl;

import ir.rahyabcp.collector.exception.BaseInvalidDatabaseOperationException;

public final class InsertRowException extends BaseInvalidDatabaseOperationException {

    public InsertRowException(String message) {
        super(message);
    }
}
