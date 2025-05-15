package ir.rahyabcp.collector.dataaccess.remote.datanodelist.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.rahyabcp.collector.dataaccess.remote.BaseResponse;
import ir.rahyabcp.collector.dataaccess.remote.ResponseHeader;

public final class DataNodeListResponse extends BaseResponse<DataNodeListResponseBody> {

    @JsonCreator
    public DataNodeListResponse(
            @JsonProperty("response_header") ResponseHeader responseHeader,
            @JsonProperty("response_body") DataNodeListResponseBody responseBody
    ) {
        super(responseHeader, responseBody);
    }
}
