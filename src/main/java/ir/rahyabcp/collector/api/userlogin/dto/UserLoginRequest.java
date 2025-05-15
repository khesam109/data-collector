package ir.rahyabcp.collector.api.userlogin.dto;

import ir.rahyabcp.collector.api.BaseRequest;
import ir.rahyabcp.collector.api.RequestHeader;

public final class UserLoginRequest extends BaseRequest<UserLoginRequestBody> {

    public UserLoginRequest(
            RequestHeader requestHeader,
            UserLoginRequestBody requestBody
    ) {
        super(requestHeader, requestBody);
    }
}
