package ir.rahyabcp.collector.dataaccess.remote.usermanagement.dto;

import ir.rahyabcp.collector.dataaccess.remote.BaseResponse;
import ir.rahyabcp.collector.dataaccess.remote.ResponseHeader;

public final class ConfigListResponse extends BaseResponse<ConfigListResponseBody> {

    public ConfigListResponse(
            ResponseHeader responseHeader,
            ConfigListResponseBody responseBody
    ) {
        super(responseHeader, responseBody);
    }
}
