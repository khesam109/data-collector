package ir.rahyabcp.collector.dataaccess.remote.userlogin.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.rahyabcp.collector.dataaccess.remote.BaseResponse;
import ir.rahyabcp.collector.dataaccess.remote.ResponseHeader;

public final class UserLoginResponse extends BaseResponse<UserLoginResponseBody> {

    @JsonCreator
    public UserLoginResponse(
            @JsonProperty("response_header") ResponseHeader responseHeader,
            @JsonProperty("response_body") UserLoginResponseBody responseBody
    ) {
        super(responseHeader, responseBody);
    }
}
