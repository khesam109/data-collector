package ir.rahyabcp.collector.service.internal.collector;

import ir.rahyabcp.collector.common.ConnectionProtocol;
import ir.rahyabcp.collector.model.DataNode;

public interface DataCollectionService<T extends DataNode> {

    void collectAndProcess(T dataNode);
    ConnectionProtocol getSupportedProtocol();
}
