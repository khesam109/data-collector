package ir.rahyabcp.collector.service.application.impl;

import ir.rahyabcp.collector.model.DataNode;
import ir.rahyabcp.collector.service.application.CollectionManagerService;
import ir.rahyabcp.collector.service.internal.collector.CollectionService;
import ir.rahyabcp.collector.service.internal.collector.DataNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class CollectionManagerServiceImpl implements CollectionManagerService {

    private final DataNodeService dataNodeService;
    private final CollectionService collectionService;

    @Autowired
    CollectionManagerServiceImpl(
            DataNodeService dataNodeService,
            CollectionService collectionService
    ) {
        this.dataNodeService = dataNodeService;
        this.collectionService = collectionService;
    }

    @Override
    public void startCollection() {
        List<DataNode> dataNodes = this.dataNodeService.getActiveDataNodes();
        dataNodes.forEach(
                collectionService::collect
        );
    }
}
