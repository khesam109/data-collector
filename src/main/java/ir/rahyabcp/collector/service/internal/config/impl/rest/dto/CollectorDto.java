package ir.rahyabcp.collector.service.internal.config.impl.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ir.rahyabcp.collector.common.ConnectionProtocol;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "protocol",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = FtpCollectorDto.class, names = {"FTP"}),
        @JsonSubTypes.Type(value = RestCollectorDto.class, names = {"REST_API"}),
        @JsonSubTypes.Type(value = DatabaseCollectorDto.class, names = {"DATABASE"}),
        @JsonSubTypes.Type(value = WebSocketCollectorDto.class, names = {"WEB_SOCKET"})
})
public abstract class CollectorDto {

    private final ConnectionProtocol protocol;
    private final SchedulingDto scheduling;

    @JsonCreator
    public CollectorDto(
            @JsonProperty("protocol") ConnectionProtocol protocol,
            @JsonProperty("scheduling") SchedulingDto scheduling
    ) {
        this.protocol = protocol;
        this.scheduling = scheduling;
    }

    public ConnectionProtocol getProtocol() {
        return protocol;
    }

    public SchedulingDto getScheduling() {
        return scheduling;
    }
}
