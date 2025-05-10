package ir.rahyabcp.collector.dataaccess.remote.node.dto.rebrand;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "dc_protocol",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = FtpPropertiesDto.class, name = "FTP"),
        @JsonSubTypes.Type(value = RdbPropertiesDto.class, name = "RDB")
})
//@JsonDeserialize(using = ExtendedPropertiesDeserializer.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ExtendedPropertiesDto {
}
