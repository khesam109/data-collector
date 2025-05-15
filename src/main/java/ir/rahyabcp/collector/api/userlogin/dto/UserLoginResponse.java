package ir.rahyabcp.collector.api.userlogin.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.rahyabcp.collector.api.BaseResponse;
import ir.rahyabcp.collector.api.ResponseHeader;

public final class UserLoginResponse extends BaseResponse<UserLoginResponseBody> {

    @JsonCreator
    public UserLoginResponse(
            @JsonProperty("response_header") ResponseHeader responseHeader,
            @JsonProperty("response_body") UserLoginResponseBody responseBody
    ) {
        super(responseHeader, responseBody);
    }
}
