package ir.rahyabcp.collector.service.internal.collector.impl;

import ir.rahyabcp.collector.common.ConnectionProtocol;
import ir.rahyabcp.collector.model.DataNode;
import ir.rahyabcp.collector.service.internal.collector.DataCollectionService;
import org.springframework.stereotype.Service;

@Service
class FtpDataCollectorService implements DataCollectionService {

    @Override
    public void collectAndProcess(DataNode dataNode) {
        System.out.println(dataNode);
    }

    @Override
    public ConnectionProtocol getSupportedProtocol() {
        return ConnectionProtocol.FTP;
    }
}
