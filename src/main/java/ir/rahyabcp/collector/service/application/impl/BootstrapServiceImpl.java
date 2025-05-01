package ir.rahyabcp.collector.service.application.impl;

import ir.rahyabcp.collector.config.ApplicationScheduleConfig;
import ir.rahyabcp.collector.scheduler.CollectionSchedulerService;
import ir.rahyabcp.collector.service.application.BootstrapService;
import ir.rahyabcp.collector.service.application.CollectionManagerService;
import ir.rahyabcp.collector.service.internal.config.ConfigLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
class BootstrapServiceImpl implements BootstrapService {

    private final ConfigLoader configLoader;
    private final CollectionSchedulerService collectionSchedulerService;
    private final CollectionManagerService collectionManagerService;


    @Autowired
    BootstrapServiceImpl(
            ConfigLoader configLoader,
            CollectionSchedulerService collectionSchedulerService,
            CollectionManagerService collectionManagerService
    ) {
        this.configLoader = configLoader;
        this.collectionSchedulerService = collectionSchedulerService;
        this.collectionManagerService = collectionManagerService;
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void bootstrap() {
        ApplicationScheduleConfig config = this.configLoader.load();
        this.collectionSchedulerService.scheduleTask(
                this.collectionManagerService::collect, config
        );
    }
}
