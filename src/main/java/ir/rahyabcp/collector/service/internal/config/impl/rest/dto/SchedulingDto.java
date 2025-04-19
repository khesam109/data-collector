package ir.rahyabcp.collector.service.internal.config.impl.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.rahyabcp.collector.common.IntervalUnit;

public record SchedulingDto(

        @JsonProperty("unit") IntervalUnit unit,
        @JsonProperty("interval") int interval
) {
}
