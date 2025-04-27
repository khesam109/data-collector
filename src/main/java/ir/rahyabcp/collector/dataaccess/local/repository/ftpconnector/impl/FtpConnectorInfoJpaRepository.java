package ir.rahyabcp.collector.dataaccess.local.repository.ftpconnector.impl;

import ir.rahyabcp.collector.dataaccess.local.entity.FtpConnectorInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface FtpConnectorInfoJpaRepository extends JpaRepository<FtpConnectorInfoEntity, Integer> {

    Optional<FtpConnectorInfoEntity> findByNodeInfoId(Integer nodeInfoId);
}
