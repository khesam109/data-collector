package ir.rahyabcp.collector.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class BaseRequest<T> {

    @JsonProperty("header") private final RequestHeader requestHeader;
    @JsonProperty("body") private final T requestBody;

    @JsonCreator
    protected BaseRequest(
            RequestHeader requestHeader,
            T requestBody
    ) {
        this.requestHeader = requestHeader;
        this.requestBody = requestBody;
    }

    public RequestHeader getRequestHeader() {
        return requestHeader;
    }

    public T getRequestBody() {
        return requestBody;
    }
}
