package ir.rahyabcp.collector.dataaccess.remote.processlist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ProcessListResponseBody(

        @JsonProperty("data")
        List<DataDto> data
) {
}
