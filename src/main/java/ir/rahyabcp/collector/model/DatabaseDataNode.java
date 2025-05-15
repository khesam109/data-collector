package ir.rahyabcp.collector.model;

import ir.rahyabcp.collector.common.ConnectionProtocol;

public class DatabaseDataNode extends DataNode {

    public DatabaseDataNode() {
        super(0, "", null, null, ConnectionProtocol.DATABASE, null, null, null);
    }
}
