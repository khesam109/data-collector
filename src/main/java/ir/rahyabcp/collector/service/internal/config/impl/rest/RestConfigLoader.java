package ir.rahyabcp.collector.service.internal.config.impl.rest;

import ir.rahyabcp.collector.model.ApplicationConfig;
import ir.rahyabcp.collector.service.internal.config.ConfigLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@ConditionalOnProperty(name = "config.source.type", havingValue = "rest")
class RestConfigLoader implements ConfigLoader {

    private final RestConfigFetcher restConfigFetcher;
    private final RestConfigResponseMapper restConfigResponseMapper;

    @Autowired
    public RestConfigLoader(
            RestConfigFetcher restConfigFetcher,
            RestConfigResponseMapper restConfigResponseMapper
    ) {
        this.restConfigFetcher = restConfigFetcher;
        this.restConfigResponseMapper = restConfigResponseMapper;
    }

    @Override
    public ApplicationConfig load() {
        return this.restConfigResponseMapper.fromRestConfigResponse(
                this.restConfigFetcher.fetch()
        );
    }
}
