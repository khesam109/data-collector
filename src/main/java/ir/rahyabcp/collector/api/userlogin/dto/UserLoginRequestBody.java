package ir.rahyabcp.collector.api.userlogin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserLoginRequestBody(

        @JsonProperty("authentication")
        AuthenticationDto authentication
) {
}
