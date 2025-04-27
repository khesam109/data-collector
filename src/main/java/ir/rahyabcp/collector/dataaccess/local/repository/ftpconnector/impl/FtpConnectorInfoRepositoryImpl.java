package ir.rahyabcp.collector.dataaccess.local.repository.ftpconnector.impl;

import ir.rahyabcp.collector.dataaccess.local.entity.FtpConnectorInfoEntity;
import ir.rahyabcp.collector.dataaccess.local.repository.ftpconnector.FtpConnectorInfoRepository;
import ir.rahyabcp.collector.exception.impl.FtpConnectorInfoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
class FtpConnectorInfoRepositoryImpl implements FtpConnectorInfoRepository {

    private final FtpConnectorInfoJpaRepository ftpConnectorInfoJpaRepository;

    @Autowired
    FtpConnectorInfoRepositoryImpl(FtpConnectorInfoJpaRepository ftpConnectorInfoJpaRepository) {
        this.ftpConnectorInfoJpaRepository = ftpConnectorInfoJpaRepository;
    }

    @Override
    public FtpConnectorInfoEntity saveFtpConnectorInfo(FtpConnectorInfoEntity ftpConnectorInfo) {
        return this.ftpConnectorInfoJpaRepository.save(ftpConnectorInfo);
    }

    @Override
    public FtpConnectorInfoEntity findByNodeInfoId(Integer nodeInfoId) {
        return this.ftpConnectorInfoJpaRepository.findByNodeInfoId(nodeInfoId).orElseThrow(
                () -> new FtpConnectorInfoNotFoundException("ftp connector info with node info id " + nodeInfoId + " not found")
        );
    }
}
