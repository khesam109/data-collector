package ir.rahyabcp.collector.dataaccess.remote._config.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ScheduleConfigResponse(
        @JsonProperty("interval") int interval
) {
}
