package ir.rahyabcp.collector.dataaccess.remote.usermanagement.dto;

import ir.rahyabcp.collector.dataaccess.remote.BaseRequest;
import ir.rahyabcp.collector.dataaccess.remote.RequestHeader;

public final class UserLogoutRequest extends BaseRequest<Void> {

    public UserLogoutRequest(RequestHeader requestHeader, Void requestBody) {
        super(requestHeader, requestBody);
    }
}
