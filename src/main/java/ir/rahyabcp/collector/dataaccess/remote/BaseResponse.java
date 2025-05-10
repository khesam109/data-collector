package ir.rahyabcp.collector.dataaccess.remote;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class BaseResponse<T> {

    @JsonProperty("response_header") private final ResponseHeader responseHeader;
    @JsonProperty("response_body") private final T responseBody;

    @JsonCreator
    protected BaseResponse(
            @JsonProperty("response_header") ResponseHeader responseHeader,
            @JsonProperty("response_body") T responseBody) {
        this.responseHeader = responseHeader;
        this.responseBody = responseBody;
    }

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public T getResponseBody() {
        return responseBody;
    }
}
