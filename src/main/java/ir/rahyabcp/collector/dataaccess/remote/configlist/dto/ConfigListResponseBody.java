package ir.rahyabcp.collector.dataaccess.remote.configlist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ConfigListResponseBody(

        @JsonProperty("public_token") String publicToken,
        @JsonProperty("session_id") String sessionId,
        @JsonProperty("device_id") String deviceId,
        @JsonProperty("business_status") String businessStatus,
        @JsonProperty("business_message") String businessMessage
) {
}
