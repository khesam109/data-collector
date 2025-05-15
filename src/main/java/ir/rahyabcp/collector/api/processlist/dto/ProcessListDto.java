package ir.rahyabcp.collector.api.processlist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProcessListDto(

        @JsonProperty("process_id")
        int processId,

        @JsonProperty("processtype")
        ProcessTypeDto processType,

        @JsonProperty("execution_unit")
        String executionUnit,

        @JsonProperty("process_status")
        String processStatus,

        @JsonProperty("synchronous_mode")
        String synchronousMode,

        @JsonProperty("polling_interval")
        Integer pollingInterval,

        @JsonProperty("repeat_interval")
        String repeatInterval,

        @JsonProperty("description")
        String description

) {
}
