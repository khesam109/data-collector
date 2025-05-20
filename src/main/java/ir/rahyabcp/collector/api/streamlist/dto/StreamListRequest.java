package ir.rahyabcp.collector.api.streamlist.dto;

import ir.rahyabcp.collector.api.BaseRequest;
import ir.rahyabcp.collector.api.RequestHeader;

public final class StreamListRequest extends BaseRequest<StreamListRequestBody> {

    public StreamListRequest(
            RequestHeader requestHeader,
            StreamListRequestBody requestBody
    ) {
        super(requestHeader, requestBody);
    }
}
