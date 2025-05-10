package ir.rahyabcp.collector.dataaccess.remote.node.dto.rebrand;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataNodeDto(

        @JsonProperty("datanode_id") int dataNodeId,
        @JsonProperty("datanode_name") String dataNodeName,
        @JsonProperty("datanode_status") String dataNodeStatus,
        @JsonProperty("dc_contentmode") String contentMode,
        @JsonProperty("dc_protocol") String protocol,
        @JsonProperty("description") String description,
        @JsonProperty("extende_properties") Map<String, Object> extendedProperties,
        @JsonProperty("dataformat") DataFormatDto dataFormat
) {
}
