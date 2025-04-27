package ir.rahyabcp.collector.model;

import ir.rahyabcp.collector.common.ConnectionProtocol;

public final class WebSocketCollectorConfig extends CollectorConfig {

    WebSocketCollectorConfig(SchedulingConfig scheduling, RetryPolicyConfig retryPolicy) {
        super(ConnectionProtocol.WEB_SOCKET, scheduling, retryPolicy);
    }
}
