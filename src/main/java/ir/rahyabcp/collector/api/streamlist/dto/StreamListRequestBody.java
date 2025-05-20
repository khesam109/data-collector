package ir.rahyabcp.collector.api.streamlist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StreamListRequestBody(

        @JsonProperty("datanode_id")
        int dataNodeId
) {
}
