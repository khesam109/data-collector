package ir.rahyabcp.collector.service.application.impl;

import ir.rahyabcp.collector.model.ApplicationConfig;
import ir.rahyabcp.collector.service.application.BootstrapService;
import ir.rahyabcp.collector.service.internal.config.ConfigLoader;
import ir.rahyabcp.collector.service.internal.config.ConfigStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class BootstrapServiceImpl implements BootstrapService {

    private final ConfigLoader configLoader;
    private final ConfigStoreService configStoreService;

    @Autowired
    BootstrapServiceImpl(ConfigLoader configLoader, ConfigStoreService configStoreService) {
        this.configLoader = configLoader;
        this.configStoreService = configStoreService;
    }

    @Override
    @Transactional
    @EventListener(ApplicationReadyEvent.class)
    public void bootstrap() {
        ApplicationConfig config = this.configLoader.load();
        this.configStoreService.persistConfig(config);
    }
}
