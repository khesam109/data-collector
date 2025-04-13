package ir.rahyabcp.collector.service.internal.config.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Service
class RestConfigFetcher {

    private final String url;
    private final int port;
    private final String path;
    private final RestClient restClient;

    @Autowired
    RestConfigFetcher(
            @Value("${config.source.rest.url}") String url,
            @Value("${config.source.rest.port}") int port,
            @Value("${config.source.rest.path}") String path
    ) {
        this.url = url;
        this.port = port;
        this.path = path;
        this.restClient = RestClient.builder().baseUrl(this.url + ":" + this.port).build();
    }

    Map<String, Object> fetch() {
        Map<String, Object> response = restClient.get().uri(this.path).retrieve().body(
                new ParameterizedTypeReference<>() {}
        );

        if (response == null) {
            throw new IllegalStateException("config server response is null");
        }

        return response;
    }
}
