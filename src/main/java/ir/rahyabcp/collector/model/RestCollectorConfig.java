package ir.rahyabcp.collector.model;

import ir.rahyabcp.collector.common.ConnectionProtocol;

public final class RestCollectorConfig extends CollectorConfig {

    RestCollectorConfig(SchedulingConfig scheduling, RetryPolicyConfig retryPolicy) {
        super(ConnectionProtocol.REST_API, scheduling, retryPolicy);
    }
}
