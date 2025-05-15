package ir.rahyabcp.collector.api.configlist.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.rahyabcp.collector.api.BaseResponse;
import ir.rahyabcp.collector.api.ResponseHeader;

public final class ConfigListResponse extends BaseResponse<ConfigListResponseBody> {

    @JsonCreator
    public ConfigListResponse(
            @JsonProperty("response_header") ResponseHeader responseHeader,
            @JsonProperty("response_body") ConfigListResponseBody responseBody
    ) {
        super(responseHeader, responseBody);
    }
}
