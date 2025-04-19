package ir.rahyabcp.collector.service.internal.config.impl.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import ir.rahyabcp.collector.common.ConnectionProtocol;

public final class WebSocketCollectorDto extends CollectorDto {

    @JsonCreator
    public WebSocketCollectorDto(SchedulingDto scheduling) {
        super(ConnectionProtocol.WEB_SOCKET, scheduling);
    }
}
