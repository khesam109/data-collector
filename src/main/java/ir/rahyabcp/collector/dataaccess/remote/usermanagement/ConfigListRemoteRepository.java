package ir.rahyabcp.collector.dataaccess.remote.usermanagement;

import ir.rahyabcp.collector.dataaccess.remote.RequestHeader;
import ir.rahyabcp.collector.dataaccess.remote.usermanagement.dto.ConfigListRequest;
import ir.rahyabcp.collector.dataaccess.remote.usermanagement.dto.ConfigListRequestBody;
import ir.rahyabcp.collector.dataaccess.remote.usermanagement.dto.ConfigListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ConfigListRemoteRepository {

    private final WebClient webClient;
    private final String resourcePath;

    @Autowired
    public ConfigListRemoteRepository(
            WebClient webClient,
            @Qualifier("resourcePath") String resourcePath
    ) {
        this.webClient = webClient;
        this.resourcePath = resourcePath;
    }

    public ConfigListResponse getPublicToken(ConfigListRequestBody body) {
        return this.webClient.post().uri(resourcePath).bodyValue(
                new ConfigListRequest(requestHeader(), body)
        ).retrieve().bodyToMono(
                ConfigListResponse.class
        ).block();
    }

    private RequestHeader requestHeader() {
        return new RequestHeader(
                null, "sma.config_list", "20220601010203"
        );
    }
}
