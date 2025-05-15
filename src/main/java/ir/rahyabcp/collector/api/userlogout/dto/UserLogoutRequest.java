package ir.rahyabcp.collector.api.userlogout.dto;

import ir.rahyabcp.collector.api.BaseRequest;
import ir.rahyabcp.collector.api.RequestHeader;

public final class UserLogoutRequest extends BaseRequest<Void> {

    public UserLogoutRequest(RequestHeader requestHeader, Void requestBody) {
        super(requestHeader, requestBody);
    }
}
