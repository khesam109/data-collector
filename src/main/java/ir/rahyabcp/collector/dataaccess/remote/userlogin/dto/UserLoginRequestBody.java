package ir.rahyabcp.collector.dataaccess.remote.userlogin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserLoginRequestBody(

        @JsonProperty("authentication")
        AuthenticationDto authentication
) {
}
