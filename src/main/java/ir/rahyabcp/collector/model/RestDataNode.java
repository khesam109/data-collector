package ir.rahyabcp.collector.model;

import ir.rahyabcp.collector.common.ConnectionProtocol;

public class RestDataNode extends DataNode {

    public RestDataNode() {
        super(ConnectionProtocol.REST_API, null);
    }
}
