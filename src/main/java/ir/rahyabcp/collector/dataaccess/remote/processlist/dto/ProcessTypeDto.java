package ir.rahyabcp.collector.dataaccess.remote.processlist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProcessTypeDto(

        @JsonProperty("processtype_id")
        int id,

        @JsonProperty("processtype_name")
        String name
) {
}
