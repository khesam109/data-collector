package ir.rahyabcp.collector.dataaccess.remote._node.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DataNodeListRequestBody(

        @JsonProperty("process_id")
        Integer processId
) {
}
