package ir.rahyabcp.collector.api.datanodelist.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * <a href="https://stackoverflow.com/questions/18757431/jackson-jsontypeinfo-as-external-property-doesnt-work-as-expected">Jackson JsonTypeInfo</a>
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record DataNodeDto(

        @JsonProperty("datanode_id")
        Integer dataNodeId,

        @JsonProperty("datanode_name")
        String dataNodeName,

        @JsonProperty("datanode_status")
        String dataNodeStatus,

        @JsonProperty("dc_contentmode")
        String contentMode,

        @JsonProperty("dc_protocol")
        String protocol,

        @JsonProperty("description")
        String description,

        @JsonProperty("dataformat")
        DataFormatDto dataFormat,

        @JsonTypeInfo(
                use = JsonTypeInfo.Id.NAME,
                include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
                property = "dc_protocol",
                visible = true
        )
        @JsonSubTypes({
                @JsonSubTypes.Type(value = FtpPropertiesDto.class, name = "FTP"),
                @JsonSubTypes.Type(value = RdbPropertiesDto.class, name = "RDB")
        })
        @JsonProperty("extende_properties")
        ExtendedPropertiesDto extendedProperties
) {
}
