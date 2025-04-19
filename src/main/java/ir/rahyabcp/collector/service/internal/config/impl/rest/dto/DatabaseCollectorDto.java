package ir.rahyabcp.collector.service.internal.config.impl.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import ir.rahyabcp.collector.common.ConnectionProtocol;

public final class DatabaseCollectorDto extends CollectorDto {

    @JsonCreator
    public DatabaseCollectorDto(SchedulingDto scheduling) {
        super(ConnectionProtocol.DATABASE, scheduling);
    }
}
