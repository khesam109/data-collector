package ir.rahyabcp.collector.di;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;

@Component
class TaskExecutorProvider {

    @Bean("dataCollectionTaskExecutor")
    Executor provideDataCollectionTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(25);
        executor.setThreadNamePrefix("data-collection-thread-");
        executor.initialize();
        return executor;
    }
}
