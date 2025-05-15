package ir.rahyabcp.collector.dataaccess.remote.datanodelist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DataNodeListRequestBody(

        @JsonProperty("process_id")
        int processId
) {
}
