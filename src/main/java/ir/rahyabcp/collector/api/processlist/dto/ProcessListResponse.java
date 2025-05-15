package ir.rahyabcp.collector.api.processlist.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.rahyabcp.collector.api.BaseResponse;
import ir.rahyabcp.collector.api.ResponseHeader;

public final class ProcessListResponse extends BaseResponse<ProcessListResponseBody> {

    @JsonCreator
    public ProcessListResponse(
            @JsonProperty("response_header") ResponseHeader requestHeader,
            @JsonProperty("response_body") ProcessListResponseBody responseBody
    ) {
        super(requestHeader, responseBody);
    }
}
