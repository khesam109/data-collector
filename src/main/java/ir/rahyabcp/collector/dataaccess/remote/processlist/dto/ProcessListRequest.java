package ir.rahyabcp.collector.dataaccess.remote.processlist.dto;

import ir.rahyabcp.collector.dataaccess.remote.BaseRequest;
import ir.rahyabcp.collector.dataaccess.remote.RequestHeader;

public final class ProcessListRequest extends BaseRequest<ProcessListRequestBody> {

    public ProcessListRequest(
            RequestHeader requestHeader,
            ProcessListRequestBody requestBody
    ) {
        super(requestHeader, requestBody);
    }
}
