package ir.rahyabcp.collector.api.configlist;

import ir.rahyabcp.collector.api.RequestHeaderFactory;
import ir.rahyabcp.collector.api.configlist.dto.ConfigListRequest;
import ir.rahyabcp.collector.api.configlist.dto.ConfigListRequestBody;
import ir.rahyabcp.collector.api.configlist.dto.ConfigListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ConfigListRemoteRepository {

    private final WebClient webClient;
    private final String resourcePath;
    private final RequestHeaderFactory requestHeaderFactory;

    @Autowired
    public ConfigListRemoteRepository(
            WebClient webClient,
            @Qualifier("resourcePath") String resourcePath,
            RequestHeaderFactory requestHeaderFactory
    ) {
        this.webClient = webClient;
        this.resourcePath = resourcePath;
        this.requestHeaderFactory = requestHeaderFactory;
    }

    public ConfigListResponse callConfigListApi(ConfigListRequestBody body) {
        return this.webClient.post().uri(resourcePath).bodyValue(
                new ConfigListRequest(
                        this.requestHeaderFactory.configList(),
                        body
                )
        ).retrieve().bodyToMono(
                ConfigListResponse.class
        ).block();
    }
}
