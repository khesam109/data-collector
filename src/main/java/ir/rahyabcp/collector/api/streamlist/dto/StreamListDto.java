package ir.rahyabcp.collector.api.streamlist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StreamListDto(

        @JsonProperty("stream_id")
        int streamId,

        @JsonProperty("stream_name")
        String streamName,

        @JsonProperty("stream_status")
        String streamStatus
) {
}
