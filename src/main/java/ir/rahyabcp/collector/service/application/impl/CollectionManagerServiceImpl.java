package ir.rahyabcp.collector.service.application.impl;

import ir.rahyabcp.collector.common.ConnectionProtocol;
import ir.rahyabcp.collector.model.DataNode;
import ir.rahyabcp.collector.service.application.CollectionManagerService;
import ir.rahyabcp.collector.service.internal.collector.DataCollectionService;
import ir.rahyabcp.collector.service.internal.datanode.DataNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
class CollectionManagerServiceImpl implements CollectionManagerService {

    private final DataNodeService dataNodeService;
    private final Map<ConnectionProtocol, DataCollectionService> dataCollectionServices;

    @Autowired
    CollectionManagerServiceImpl(
            DataNodeService dataNodeService,
            List<DataCollectionService> dataCollectionServices
    ) {
        this.dataNodeService = dataNodeService;
        this.dataCollectionServices = new HashMap<>();
        dataCollectionServices.forEach(
                service -> this.dataCollectionServices.put(service.getSupportedProtocol(), service)
        );
    }

    @Override
    public void collect() {
        List<DataNode> dataNodes = this.dataNodeService.getActiveDataNodes();
        dataNodes.forEach(this::collect);
    }

    private void collect(DataNode dataNode) {
        DataCollectionService service = dataCollectionServices.get(dataNode.getConnectionProtocol());
        if (service != null) {
            service.collectAndProcess(dataNode);
        } else {
            throw new IllegalStateException(
                    "No DataCollectionService found for protocol: " + dataNode.getConnectionProtocol()
            );
        }
    }
}
