package ir.rahyabcp.collector.service.internal.collector.impl;

import ir.rahyabcp.collector.common.ConnectionProtocol;
import ir.rahyabcp.collector.model.WebSocketDataNode;
import ir.rahyabcp.collector.service.internal.collector.DataCollectionService;
import org.springframework.stereotype.Service;

@Service
class WebSocketDataCollectionService implements DataCollectionService<WebSocketDataNode> {

    @Override
    public void collectAndProcess(WebSocketDataNode dataNode) {
        throw new UnsupportedOperationException("this method is not implemented yet");
    }

    @Override
    public ConnectionProtocol getSupportedProtocol() {
        return ConnectionProtocol.WEB_SOCKET;
    }
}
