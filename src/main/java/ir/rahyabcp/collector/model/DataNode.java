package ir.rahyabcp.collector.model;

import ir.rahyabcp.collector.common.ConnectionProtocol;

public abstract class DataNode {

    private final ConnectionProtocol connectionProtocol;
    private final RetryPolicy retryPolicy;

    protected DataNode(
            ConnectionProtocol connectionProtocol,
            RetryPolicy retryPolicy
    ) {
        this.connectionProtocol = connectionProtocol;
        this.retryPolicy = retryPolicy;
    }

    public ConnectionProtocol getConnectionProtocol() {
        return connectionProtocol;
    }

    public RetryPolicy getRetryPolicy() {
        return retryPolicy;
    }
}
