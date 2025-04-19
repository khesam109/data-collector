package ir.rahyabcp.collector.model;

import ir.rahyabcp.collector.common.IntervalUnit;

public record SchedulingConfig(

        int interval,
        IntervalUnit unit
) {
}
