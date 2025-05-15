package ir.rahyabcp.collector.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseHeader(

        @JsonProperty("message_code") String messageCode,
        @JsonProperty("message_text") String messageText,
        @JsonProperty("sysdate") String sysDate,
        @JsonProperty("encoding") String encoding
) {
}
