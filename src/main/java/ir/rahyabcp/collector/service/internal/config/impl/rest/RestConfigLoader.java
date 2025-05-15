package ir.rahyabcp.collector.service.internal.config.impl.rest;

import ir.rahyabcp.collector.api.processlist.ProcessListRemoteRepository;
import ir.rahyabcp.collector.api.processlist.dto.ProcessListRequestBody;
import ir.rahyabcp.collector.api.processlist.dto.ProcessListResponse;
import ir.rahyabcp.collector.config.ApplicationInfoConfig;
import ir.rahyabcp.collector.model.SchedulingInfo;
import ir.rahyabcp.collector.service.internal.config.ConfigLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
@Primary
@ConditionalOnProperty(name = "config.source.type", havingValue = "rest")
class RestConfigLoader implements ConfigLoader {

    private final ApplicationInfoConfig applicationInfoConfig;
    private final ProcessListRemoteRepository processListRemoteRepository;

    @Autowired
    RestConfigLoader(
            ApplicationInfoConfig applicationInfoConfig,
            ProcessListRemoteRepository processListRemoteRepository
    ) {
        this.applicationInfoConfig = applicationInfoConfig;
        this.processListRemoteRepository = processListRemoteRepository;
    }
    /**
     * This method is responsible for loading the configuration from the remote repository.
     * It uses the {@link ProcessListRemoteRepository} to call the API and retrieve the configuration.
     * The method is annotated with {@link Retryable} to handle transient errors and retry the operation.
     *
     * @return SchedulingInfo object containing the polling interval
     */
    @Override
    @Retryable(maxAttempts = 5, backoff = @Backoff(delay = 10000))
    public SchedulingInfo load() {
        ProcessListResponse response = this.processListRemoteRepository.callProcessListApi(createProcessListBody());
        return new SchedulingInfo(response.getResponseBody().data().getFirst().pollingInterval());
    }

    private ProcessListRequestBody createProcessListBody() {
        return new ProcessListRequestBody(
                this.applicationInfoConfig.getProcessId()
        );
    }
}
