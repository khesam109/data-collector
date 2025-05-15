package ir.rahyabcp.collector.dataaccess.remote.processlist.dto;

import ir.rahyabcp.collector.dataaccess.remote.BaseRequest;
import ir.rahyabcp.collector.dataaccess.remote.RequestHeader;

public final class ProcessListResponse extends BaseRequest<ProcessListResponseBody> {

    public ProcessListResponse(
            RequestHeader requestHeader,
            ProcessListResponseBody requestBody
    ) {
        super(requestHeader, requestBody);
    }
}
