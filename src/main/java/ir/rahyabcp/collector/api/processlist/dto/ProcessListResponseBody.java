package ir.rahyabcp.collector.api.processlist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ProcessListResponseBody(

        @JsonProperty("data")
        List<ProcessListDto> data
) {
}
