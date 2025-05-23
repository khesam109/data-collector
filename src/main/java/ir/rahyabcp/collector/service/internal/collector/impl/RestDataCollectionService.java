package ir.rahyabcp.collector.service.internal.collector.impl;

import ir.rahyabcp.collector.common.ConnectionProtocol;
import ir.rahyabcp.collector.model.RestDataNode;
import ir.rahyabcp.collector.service.internal.collector.DataCollectionService;
import org.springframework.stereotype.Service;

@Service
class RestDataCollectionService implements DataCollectionService<RestDataNode> {

    @Override
    public void collectAndProcess(RestDataNode dataNode) {
        throw new UnsupportedOperationException("this method is not implemented yet");
    }

    @Override
    public ConnectionProtocol getSupportedProtocol() {
        return ConnectionProtocol.REST_API;
    }
}
