package ir.rahyabcp.collector.service.internal.config.impl.rest;

import ir.rahyabcp.collector.config.ApplicationScheduleConfig;
import ir.rahyabcp.collector.dataaccess.remote.processlist.ProcessListRemoteRepository;
import ir.rahyabcp.collector.dataaccess.remote.processlist.dto.ProcessListRequestBody;
import ir.rahyabcp.collector.dataaccess.remote.processlist.dto.ProcessListResponse;
import ir.rahyabcp.collector.service.internal.config.ConfigLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
@Primary
@ConditionalOnProperty(name = "config.source.type", havingValue = "rest")
class RestConfigLoader implements ConfigLoader {

    private final Integer processId;
    private final ProcessListRemoteRepository processListRemoteRepository;

    @Autowired
    RestConfigLoader(
            @Value("${spring.application.process-id}") Integer processId,
            ProcessListRemoteRepository processListRemoteRepository
    ) {
        this.processId = processId;
        this.processListRemoteRepository = processListRemoteRepository;
    }

    //FIXME: the process_list_response should contains interval!
    @Override
    @Retryable(maxAttempts = 5, backoff = @Backoff(delay = 10000))
    public ApplicationScheduleConfig load() {
        ProcessListResponse response = this.processListRemoteRepository.callProcessListApi(createProcessListBody());
        return new ApplicationScheduleConfig(0);
    }

    private ProcessListRequestBody createProcessListBody() {
        return new ProcessListRequestBody(processId);
    }
}
