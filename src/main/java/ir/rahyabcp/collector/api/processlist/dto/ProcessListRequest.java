package ir.rahyabcp.collector.api.processlist.dto;

import ir.rahyabcp.collector.api.BaseRequest;
import ir.rahyabcp.collector.api.RequestHeader;

public final class ProcessListRequest extends BaseRequest<ProcessListRequestBody> {

    public ProcessListRequest(
            RequestHeader requestHeader,
            ProcessListRequestBody requestBody
    ) {
        super(requestHeader, requestBody);
    }
}
