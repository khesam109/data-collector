package ir.rahyabcp.collector.api.configlist.dto;

import ir.rahyabcp.collector.api.BaseRequest;
import ir.rahyabcp.collector.api.RequestHeader;

public final class ConfigListRequest extends BaseRequest<ConfigListRequestBody> {

    public ConfigListRequest(
            RequestHeader requestHeader,
            ConfigListRequestBody requestBody
    ) {
        super(requestHeader, requestBody);
    }
}
