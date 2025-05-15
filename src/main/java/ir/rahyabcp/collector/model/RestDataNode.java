package ir.rahyabcp.collector.model;

import ir.rahyabcp.collector.common.ConnectionProtocol;

public class RestDataNode extends DataNode {

    public RestDataNode() {
        super(0, "", null, null, ConnectionProtocol.REST_API, null, null, null);
    }
}
