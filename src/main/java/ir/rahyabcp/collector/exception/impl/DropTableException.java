package ir.rahyabcp.collector.exception.impl;

import ir.rahyabcp.collector.exception.BaseInvalidDatabaseOperationException;

public final class DropTableException extends BaseInvalidDatabaseOperationException {

    public DropTableException(String message) {
        super(message);
    }
}
