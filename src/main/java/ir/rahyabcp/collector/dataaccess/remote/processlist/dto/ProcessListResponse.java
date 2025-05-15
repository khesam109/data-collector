package ir.rahyabcp.collector.dataaccess.remote.processlist.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.rahyabcp.collector.dataaccess.remote.BaseResponse;
import ir.rahyabcp.collector.dataaccess.remote.ResponseHeader;

public final class ProcessListResponse extends BaseResponse<ProcessListResponseBody> {

    @JsonCreator
    public ProcessListResponse(
            @JsonProperty("response_header") ResponseHeader requestHeader,
            @JsonProperty("response_body") ProcessListResponseBody responseBody
    ) {
        super(requestHeader, responseBody);
    }
}
