package ir.rahyabcp.collector.model;

import ir.rahyabcp.collector.common.ConnectionProtocol;

public abstract class CollectorConfig {

    private ConnectionProtocol connectionProtocol;
    private SchedulingConfig scheduling;
    private RetryPolicyConfig retryPolicy;

    public ConnectionProtocol getConnectionProtocol() {
        return connectionProtocol;
    }

    public void setConnectionProtocol(ConnectionProtocol connectionProtocol) {
        this.connectionProtocol = connectionProtocol;
    }

    public SchedulingConfig getScheduling() {
        return scheduling;
    }

    public void setScheduling(SchedulingConfig scheduling) {
        this.scheduling = scheduling;
    }

    public RetryPolicyConfig getRetryPolicy() {
        return retryPolicy;
    }

    public void setRetryPolicy(RetryPolicyConfig retryPolicy) {
        this.retryPolicy = retryPolicy;
    }
}
