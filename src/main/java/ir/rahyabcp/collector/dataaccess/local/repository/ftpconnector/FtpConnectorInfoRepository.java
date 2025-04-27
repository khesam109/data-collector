package ir.rahyabcp.collector.dataaccess.local.repository.ftpconnector;

import ir.rahyabcp.collector.dataaccess.local.entity.FtpConnectorInfoEntity;

public interface FtpConnectorInfoRepository {

    FtpConnectorInfoEntity saveFtpConnectorInfo(FtpConnectorInfoEntity ftpConnectorInfo);
    FtpConnectorInfoEntity findByNodeInfoId(Integer nodeInfoId);
}
