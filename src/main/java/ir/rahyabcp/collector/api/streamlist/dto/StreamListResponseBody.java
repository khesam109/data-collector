package ir.rahyabcp.collector.api.streamlist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record StreamListResponseBody(

        @JsonProperty("data")
        List<StreamListDto> data
) {
}
