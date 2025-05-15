package ir.rahyabcp.collector.dataaccess.remote.userlogin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserLoginResponseBody(

        @JsonProperty("token") String token,
        @JsonProperty("init_page") String initPage,
        @JsonProperty("business_status") String businessStatus,
        @JsonProperty("business_message") String businessMessage
) {
}
