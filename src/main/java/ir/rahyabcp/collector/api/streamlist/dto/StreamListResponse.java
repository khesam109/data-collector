package ir.rahyabcp.collector.api.streamlist.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.rahyabcp.collector.api.BaseResponse;
import ir.rahyabcp.collector.api.ResponseHeader;

public class StreamListResponse extends BaseResponse<StreamListResponseBody> {

    @JsonCreator
    public StreamListResponse(
             @JsonProperty("response_header") ResponseHeader responseHeader,
             @JsonProperty("response_body")StreamListResponseBody responseBody
    ) {
        super(responseHeader, responseBody);
    }
}
