package ir.rahyabcp.collector.dataaccess.remote.node.dto.rebrand;

import ir.rahyabcp.collector.dataaccess.remote.BaseRequest;
import ir.rahyabcp.collector.dataaccess.remote.RequestHeader;

public final class DataNodeListRequest extends BaseRequest<DataNodeListRequestBody> {

    public DataNodeListRequest(
            RequestHeader requestHeader,
            DataNodeListRequestBody requestBody
    ) {
        super(requestHeader, requestBody);
    }
}
