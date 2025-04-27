package ir.rahyabcp.collector.service.internal.config.impl;

import ir.rahyabcp.collector.common.ConnectionProtocol;
import ir.rahyabcp.collector.model.ApplicationConfig;
import ir.rahyabcp.collector.model.CollectorConfig;
import ir.rahyabcp.collector.model.FtpCollectorConfig;
import ir.rahyabcp.collector.service.internal.config.ConfigStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class ConfigStoreServiceImpl implements ConfigStoreService {

    private final FtpConfigStoreService ftpConfigStoreService;

    @Autowired
    ConfigStoreServiceImpl(FtpConfigStoreService ftpConfigStoreService) {
        this.ftpConfigStoreService = ftpConfigStoreService;
    }

    public void persistConfig(ApplicationConfig config) {
        for (CollectorConfig cc : config.getCollectors()) {
            if (cc.getConnectionProtocol() == ConnectionProtocol.FTP) {
                this.ftpConfigStoreService.persistFtpConnectorConfig((FtpCollectorConfig) cc);
            }
        }
    }
}
