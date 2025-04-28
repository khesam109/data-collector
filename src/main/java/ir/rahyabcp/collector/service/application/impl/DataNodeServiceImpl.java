package ir.rahyabcp.collector.service.application.impl;

import ir.rahyabcp.collector.model.DataNode;
import ir.rahyabcp.collector.service.application.DataNodeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class DataNodeServiceImpl implements DataNodeService {

    @Override
    public List<DataNode> getActiveDataNodes() {
        return List.of();
    }
}
