package ir.rahyabcp.collector.dataaccess.remote.usermanagement.dto;

import ir.rahyabcp.collector.dataaccess.remote.BaseRequest;
import ir.rahyabcp.collector.dataaccess.remote.RequestHeader;

public final class UserLoginRequest extends BaseRequest<UserLoginRequestBody> {

    public UserLoginRequest(
            RequestHeader requestHeader,
            UserLoginRequestBody requestBody
    ) {
        super(requestHeader, requestBody);
    }
}
