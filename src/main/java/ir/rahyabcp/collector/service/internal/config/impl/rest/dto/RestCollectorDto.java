package ir.rahyabcp.collector.service.internal.config.impl.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.rahyabcp.collector.common.ConnectionProtocol;

public final class RestCollectorDto extends CollectorDto {

    private final String url;

    @JsonCreator
    public RestCollectorDto(
            @JsonProperty("scheduling") SchedulingDto scheduling,
            @JsonProperty("url") String url
    ) {
        super(ConnectionProtocol.REST_API, scheduling);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
