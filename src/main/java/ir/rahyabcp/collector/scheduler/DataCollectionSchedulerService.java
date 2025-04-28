package ir.rahyabcp.collector.scheduler;

import ir.rahyabcp.collector.config.ApplicationScheduleConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ScheduledFuture;

@Service
public class DataCollectionSchedulerService {

    private final TaskScheduler taskScheduler;
    private ScheduledFuture<?> scheduledTask;

    @Autowired
    public DataCollectionSchedulerService(
            TaskScheduler taskScheduler
    ) {
        this.taskScheduler = taskScheduler;
    }

    public void scheduleTask(Runnable task, ApplicationScheduleConfig config) {
        cancelExistingTask();

        PeriodicTrigger trigger = new PeriodicTrigger(
                Duration.of(config.interval(), ChronoUnit.SECONDS)
        );

        this.scheduledTask = taskScheduler.schedule(task, trigger);
    }

    public void cancelExistingTask() {
        if (scheduledTask != null) {
            scheduledTask.cancel(false);
        }
    }

}
