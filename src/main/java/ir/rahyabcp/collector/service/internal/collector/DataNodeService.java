package ir.rahyabcp.collector.service.internal.collector;

import ir.rahyabcp.collector.model.DataNode;

import java.util.List;

public interface DataNodeService {

    List<DataNode> getActiveDataNodes();
}
