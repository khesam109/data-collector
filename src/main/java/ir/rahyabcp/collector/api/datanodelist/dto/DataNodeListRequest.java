package ir.rahyabcp.collector.api.datanodelist.dto;

import ir.rahyabcp.collector.api.BaseRequest;
import ir.rahyabcp.collector.api.RequestHeader;

public final class DataNodeListRequest extends BaseRequest<DataNodeListRequestBody> {

    public DataNodeListRequest(
            RequestHeader requestHeader,
            DataNodeListRequestBody requestBody
    ) {
        super(requestHeader, requestBody);
    }
}
