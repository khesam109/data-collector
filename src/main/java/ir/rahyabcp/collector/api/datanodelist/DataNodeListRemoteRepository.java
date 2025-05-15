package ir.rahyabcp.collector.api.datanodelist;

import ir.rahyabcp.collector.api.RequestHeaderFactory;
import ir.rahyabcp.collector.api.datanodelist.dto.DataNodeListRequest;
import ir.rahyabcp.collector.api.datanodelist.dto.DataNodeListRequestBody;
import ir.rahyabcp.collector.api.datanodelist.dto.DataNodeListResponse;
import ir.rahyabcp.collector.service.internal.usermanagement.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class DataNodeListRemoteRepository {

    private final WebClient webClient;
    private final String resourcePath;
    private final RequestHeaderFactory requestHeaderFactory;
    private final TokenService tokenService;

    @Autowired
    public DataNodeListRemoteRepository(
            WebClient webClient,
            String resourcePath,
            RequestHeaderFactory requestHeaderFactory,
            TokenService tokenService
    ) {
        this.webClient = webClient;
        this.resourcePath = resourcePath;
        this.requestHeaderFactory = requestHeaderFactory;
        this.tokenService = tokenService;
    }

    public DataNodeListResponse callDataNodeListApi(DataNodeListRequestBody body) {
        return this.webClient.post().uri(resourcePath).bodyValue(
                new DataNodeListRequest(
                        this.requestHeaderFactory.dataNodeList(
                                this.tokenService.getToken()
                        ),
                        body
                )
        ).retrieve().bodyToMono(
                DataNodeListResponse.class
        ).block();
    }
}
