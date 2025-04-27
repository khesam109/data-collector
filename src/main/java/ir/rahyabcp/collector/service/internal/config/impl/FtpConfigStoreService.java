package ir.rahyabcp.collector.service.internal.config.impl;

import ir.rahyabcp.collector.common.ConnectionProtocol;
import ir.rahyabcp.collector.dataaccess.local.entity.FtpConnectorInfoEntity;
import ir.rahyabcp.collector.dataaccess.local.entity.NodeInfoEntity;
import ir.rahyabcp.collector.dataaccess.local.repository.ftpconnector.FtpConnectorInfoRepository;
import ir.rahyabcp.collector.dataaccess.local.repository.nodeinfo.NodeInfoRepository;
import ir.rahyabcp.collector.model.FtpCollectorConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class FtpConfigStoreService {

    private final NodeInfoRepository nodeInfoRepository;
    private final FtpConnectorInfoRepository ftpConnectorInfoRepository;

    @Autowired
    FtpConfigStoreService(
            NodeInfoRepository nodeInfoRepository,
            FtpConnectorInfoRepository ftpConnectorInfoRepository
    ) {
        this.nodeInfoRepository = nodeInfoRepository;
        this.ftpConnectorInfoRepository = ftpConnectorInfoRepository;
    }

    public void persistFtpConnectorConfig(FtpCollectorConfig config) {
        NodeInfoEntity nodeInfoEntity = new NodeInfoEntity();
        nodeInfoEntity.setConnectionProtocol(ConnectionProtocol.FTP);
        nodeInfoEntity.addScheduleInfo(
                config.getScheduling().interval(),
                config.getScheduling().unit()
        );
        nodeInfoEntity = this.nodeInfoRepository.saveNodeInfo(nodeInfoEntity);

        FtpConnectorInfoEntity ftpConnectorInfo = new FtpConnectorInfoEntity();
        ftpConnectorInfo.setNodeInfoId(nodeInfoEntity.getId());
        ftpConnectorInfo.setHost(config.getHost());
        ftpConnectorInfo.setPort(config.getPort());
        ftpConnectorInfo.setUsername(config.getUsername());
        ftpConnectorInfo.setPassword(config.getPassword());
        ftpConnectorInfo.setRemoteDirectory("/test"); //FIXME: add remote directory to dto
        this.ftpConnectorInfoRepository.saveFtpConnectorInfo(ftpConnectorInfo);
    }
}
