package ir.rahyabcp.collector.service.internal.config.impl.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ConfigDto(

        @JsonProperty("collectors") List<CollectorDto> collectors
) {

}
