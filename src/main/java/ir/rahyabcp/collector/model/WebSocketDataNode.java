package ir.rahyabcp.collector.model;

import ir.rahyabcp.collector.common.ConnectionProtocol;

public class WebSocketDataNode extends DataNode {

    public WebSocketDataNode() {
        super(0, "", null, null, ConnectionProtocol.WEB_SOCKET, null, null, null);
    }
}
