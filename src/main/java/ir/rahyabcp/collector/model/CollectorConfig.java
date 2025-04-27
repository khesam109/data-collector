package ir.rahyabcp.collector.model;

import ir.rahyabcp.collector.common.ConnectionProtocol;

public abstract class CollectorConfig {

    private final ConnectionProtocol connectionProtocol;
    private final SchedulingConfig scheduling;
    private final RetryPolicyConfig retryPolicy;

    protected CollectorConfig(
            ConnectionProtocol connectionProtocol,
            SchedulingConfig scheduling,
            RetryPolicyConfig retryPolicy
    ) {
        this.connectionProtocol = connectionProtocol;
        this.scheduling = scheduling;
        this.retryPolicy = retryPolicy;
    }


    public ConnectionProtocol getConnectionProtocol() {
        return connectionProtocol;
    }


    public SchedulingConfig getScheduling() {
        return scheduling;
    }

    public RetryPolicyConfig getRetryPolicy() {
        return retryPolicy;
    }

}
