package ir.rahyabcp.collector.dataaccess.remote.datanodelist.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataNodeListResponseBody(

        @JsonProperty("data")
        List<DataNodeDto> dataNodes
) {
}
