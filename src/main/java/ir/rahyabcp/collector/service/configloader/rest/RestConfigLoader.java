package ir.rahyabcp.collector.service.configloader.rest;

import ir.rahyabcp.collector.common.CollectorConfig;
import ir.rahyabcp.collector.service.configloader.ConfigLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@ConditionalOnProperty(name = "config.source.type", havingValue = "rest")
class RestConfigLoader implements ConfigLoader {

    private final RestConfigFetcher restConfigFetcher;
    private final ConfigRestResponseMapper configRestResponseMapper;

    @Autowired
    public RestConfigLoader(
            RestConfigFetcher restConfigFetcher,
            ConfigRestResponseMapper configRestResponseMapper
    ) {
        this.restConfigFetcher = restConfigFetcher;
        this.configRestResponseMapper = configRestResponseMapper;
    }

    @Override
    public CollectorConfig load() {
        return this.configRestResponseMapper.fromRestCollectorConfigResponse(
                this.restConfigFetcher.fetch()
        );
    }
}
