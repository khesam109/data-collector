package ir.rahyabcp.collector.service.internal.datanode;

import ir.rahyabcp.collector.model.DataNode;

import java.util.List;

public interface DataNodeService {

    List<DataNode> getActiveDataNodes();
}
