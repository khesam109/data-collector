package ir.rahyabcp.collector.api.datanodelist.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.rahyabcp.collector.api.BaseResponse;
import ir.rahyabcp.collector.api.ResponseHeader;

public final class DataNodeListResponse extends BaseResponse<DataNodeListResponseBody> {

    @JsonCreator
    public DataNodeListResponse(
            @JsonProperty("response_header") ResponseHeader responseHeader,
            @JsonProperty("response_body") DataNodeListResponseBody responseBody
    ) {
        super(responseHeader, responseBody);
    }
}
