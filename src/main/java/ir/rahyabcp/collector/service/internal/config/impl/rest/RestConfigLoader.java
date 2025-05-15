package ir.rahyabcp.collector.service.internal.config.impl.rest;

import ir.rahyabcp.collector.config.ApplicationScheduleConfig;
import ir.rahyabcp.collector.dataaccess.remote._config.ScheduleConfigRemoteRepository;
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

    private final ScheduleConfigRemoteRepository scheduleConfigRemoteRepository;
    private final RestConfigResponseMapper restConfigResponseMapper;

    @Autowired
    public RestConfigLoader(
            ScheduleConfigRemoteRepository scheduleConfigRemoteRepository,
            RestConfigResponseMapper restConfigResponseMapper
    ) {
        this.scheduleConfigRemoteRepository = scheduleConfigRemoteRepository;
        this.restConfigResponseMapper = restConfigResponseMapper;
    }

    @Override
    @Retryable(maxAttempts = 5, backoff = @Backoff(delay = 10000))
    public ApplicationScheduleConfig load() {
        return this.restConfigResponseMapper.fromScheduleConfigResponse(
                this.scheduleConfigRemoteRepository.fetch()
        );
    }
}
