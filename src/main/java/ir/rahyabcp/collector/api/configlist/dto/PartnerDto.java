package ir.rahyabcp.collector.api.configlist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PartnerDto(
        @JsonProperty("domain") String domain,
        @JsonProperty("token") String token
) {
}
