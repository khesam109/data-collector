package ir.rahyabcp.collector.service.internal.config.impl.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SchedulingDto(

        @JsonProperty("interval") int interval
) {
}
