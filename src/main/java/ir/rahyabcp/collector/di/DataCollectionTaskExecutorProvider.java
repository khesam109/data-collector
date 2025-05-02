package ir.rahyabcp.collector.di;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Component
class DataCollectionTaskExecutorProvider {

    /**
     * Describes the behavior of the thread pool execution and task handling.
     *
     * <p>The thread pool processes tasks as follows:</p>
     * <ul>
     *     <li><strong>First 5 tasks:</strong> Handled immediately by core threads.</li>
     *     <li><strong>Tasks 6-30:</strong> Placed into the queue, which has a capacity of 25.</li>
     *     <li><strong>Tasks 31-35:</strong> New threads are created, up to a maximum of 10 threads.</li>
     *     <li><strong>Task 36 and beyond:</strong> Triggers rejection policies.</li>
     * </ul>
     * <strong><i>Optimal Max Threads = Number of Cores × (1 + Wait Time / Service Time)</i></></strong>
     * @return The status or result of the thread pool execution.
     */
    @Bean("dataCollectionTaskExecutor")
    Executor provideDataCollectionTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10); // Allow more scaling
        executor.setQueueCapacity(25); // Larger queue
        executor.setThreadNamePrefix("data-collection-thread-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setAllowCoreThreadTimeOut(true);
        executor.setKeepAliveSeconds(30);
        executor.initialize();
        return executor;
    }
}
