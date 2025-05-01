package ir.rahyabcp.collector.dataaccess.remote.node.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "protocol",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = FtpDataNodeDto.class, names = {"FTP"}),
        @JsonSubTypes.Type(value = RestDataNodeDto.class, names = {"REST_API"}),
        @JsonSubTypes.Type(value = DatabaseDataNodeDto.class, names = {"DATABASE"}),
        @JsonSubTypes.Type(value = WebSocketDataNodeDto.class, names = {"WEB_SOCKET"})
})
public abstract class DataNodeDto {

    private final String protocol;

    @JsonCreator
    public DataNodeDto(
            @JsonProperty("protocol") String protocol
    ) {
        this.protocol = protocol;
    }

    public String getProtocol() {
        return protocol;
    }
}
