package ir.rahyabcp.collector.dataaccess.remote.config.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ScheduleConfigResponse(
        @JsonProperty("interval") int interval
) {
}
