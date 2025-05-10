package ir.rahyabcp.collector.dataaccess.remote.usermanagement.dto;

import ir.rahyabcp.collector.dataaccess.remote.BaseResponse;
import ir.rahyabcp.collector.dataaccess.remote.ResponseHeader;

public final class UserLoginResponse extends BaseResponse<UserLoginResponseBody> {


    public UserLoginResponse(
            ResponseHeader responseHeader,
            UserLoginResponseBody responseBody
    ) {
        super(responseHeader, responseBody);
    }
}
