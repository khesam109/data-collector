package ir.rahyabcp.collector.common;

import java.util.List;

public record DataCollectorConfig(
        List<NodeConnectorConfig> connector,
        SchedulingConfig scheduling,
        RetryPolicyConfig retryPolicy
) {
}
