package ir.rahyabcp.collector.dataaccess.remote.processlist.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.rahyabcp.collector.dataaccess.remote.BaseRequest;
import ir.rahyabcp.collector.dataaccess.remote.RequestHeader;

public final class ProcessListResponse extends BaseRequest<ProcessListResponseBody> {

    @JsonCreator
    public ProcessListResponse(
            @JsonProperty("response_header") RequestHeader requestHeader,
            @JsonProperty("response_body") ProcessListResponseBody requestBody
    ) {
        super(requestHeader, requestBody);
    }
}
