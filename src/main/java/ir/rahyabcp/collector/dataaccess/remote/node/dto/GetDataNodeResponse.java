package ir.rahyabcp.collector.dataaccess.remote.node.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record GetDataNodeResponse(
        @JsonProperty("dataNodes") List<DataNodeDto> dataNodes
) {
}
