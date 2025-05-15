package ir.rahyabcp.collector.dataaccess.remote.userlogin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthenticationDto(

        @JsonProperty("username")
        String username,

        @JsonProperty("password")
        String password,

        @JsonProperty("service")
        String service
) {
}
