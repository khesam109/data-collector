package ir.rahyabcp.collector.service.application.impl;

import ir.rahyabcp.collector.model.ApplicationConfig;
import ir.rahyabcp.collector.service.internal.config.ConfigLoader;
import ir.rahyabcp.collector.service.internal.config.ConfigService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class BootstrapServiceImpl {

    private final ConfigLoader configLoader;
    private final ConfigService configService;

    @Autowired
    BootstrapServiceImpl(ConfigLoader configLoader, ConfigService configService) {
        this.configLoader = configLoader;
        this.configService = configService;
    }

    @Transactional
    public void persistConfig() {
        ApplicationConfig config = this.configLoader.load();
        this.configService.persistConfig(config);
    }
}
