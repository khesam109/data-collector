package ir.rahyabcp.collector.service.internal.collector.impl;

import ir.rahyabcp.collector.common.ConnectionProtocol;
import ir.rahyabcp.collector.model.DatabaseDataNode;
import ir.rahyabcp.collector.service.internal.collector.DataCollectionService;
import org.springframework.stereotype.Service;

@Service
class DatabaseDataCollectionService implements DataCollectionService<DatabaseDataNode> {

    @Override
    public void collectAndProcess(DatabaseDataNode dataNode) {
        throw new UnsupportedOperationException("this method is not implemented yet");
    }

    @Override
    public ConnectionProtocol getSupportedProtocol() {
        return ConnectionProtocol.DATABASE;
    }
}
