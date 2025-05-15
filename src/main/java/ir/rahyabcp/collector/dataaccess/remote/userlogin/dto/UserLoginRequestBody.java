package ir.rahyabcp.collector.dataaccess.remote.userlogin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserLoginRequestBody(

        @JsonProperty("authentication") Authentication authentication
) {

    public record Authentication(
            @JsonProperty("username") String username,
            @JsonProperty("password")String password,
            @JsonProperty("service")String service
    ) {
    }
}
