package ir.rahyabcp.collector.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class BaseResponse<T> {

    private final ResponseHeader responseHeader;
    private final T responseBody;

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
