package ir.rahyabcp.collector.dataaccess.remote.node.dto.rebrand;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DataNodeListRequestBody(

        @JsonProperty("process_id") int processId
) {
}
