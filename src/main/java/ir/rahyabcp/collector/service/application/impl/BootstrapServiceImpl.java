package ir.rahyabcp.collector.service.application.impl;

import ir.rahyabcp.collector.config.ApplicationScheduleConfig;
import ir.rahyabcp.collector.scheduler.DataCollectionSchedulerService;
import ir.rahyabcp.collector.service.application.BootstrapService;
import ir.rahyabcp.collector.service.internal.config.ConfigLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
class BootstrapServiceImpl implements BootstrapService {

    private final ConfigLoader configLoader;
    private final DataCollectionSchedulerService dataCollectionSchedulerService;
    private final TestService testService;


    @Autowired
    BootstrapServiceImpl(
            ConfigLoader configLoader,
            DataCollectionSchedulerService dataCollectionSchedulerService,
            TestService testService
    ) {
        this.configLoader = configLoader;
        this.dataCollectionSchedulerService = dataCollectionSchedulerService;
        this.testService = testService;
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void bootstrap() {
        ApplicationScheduleConfig config = this.configLoader.load();
        this.dataCollectionSchedulerService.scheduleTask(
                this.testService::print, config
        );
    }
}
