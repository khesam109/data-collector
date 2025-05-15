package ir.rahyabcp.collector.api.processlist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProcessListRequestBody(

        @JsonProperty("process_id")
        int processId
) {
}
