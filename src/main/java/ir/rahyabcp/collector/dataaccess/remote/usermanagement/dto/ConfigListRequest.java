package ir.rahyabcp.collector.dataaccess.remote.usermanagement.dto;

import ir.rahyabcp.collector.dataaccess.remote.BaseRequest;
import ir.rahyabcp.collector.dataaccess.remote.RequestHeader;

public final class ConfigListRequest extends BaseRequest<ConfigListRequestBody> {

    public ConfigListRequest(
            RequestHeader requestHeader,
            ConfigListRequestBody requestBody
    ) {
        super(requestHeader, requestBody);
    }
}
