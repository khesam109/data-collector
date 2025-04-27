package ir.rahyabcp.collector.model;


import ir.rahyabcp.collector.common.ConnectionProtocol;

public final class DatabaseCollectorConfig extends CollectorConfig {

    DatabaseCollectorConfig(
            SchedulingConfig scheduling,
            RetryPolicyConfig retryPolicy
    ) {
        super(ConnectionProtocol.DATABASE, scheduling, retryPolicy);
    }
}
