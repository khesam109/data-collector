package ir.rahyabcp.collector.api.streamlist;

import ir.rahyabcp.collector.api.RequestHeaderFactory;
import ir.rahyabcp.collector.api.streamlist.dto.StreamListRequest;
import ir.rahyabcp.collector.api.streamlist.dto.StreamListRequestBody;
import ir.rahyabcp.collector.api.streamlist.dto.StreamListResponse;
import ir.rahyabcp.collector.service.internal.usermanagement.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class StreamListRemoteRepository {

    private final WebClient webClient;
    private final String resourcePath;
    private final RequestHeaderFactory requestHeaderFactory;
    private final TokenService tokenService;

    @Autowired
    public StreamListRemoteRepository(
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

    public StreamListResponse callStreamListApi(StreamListRequestBody body) {
        return this.webClient.post().uri(resourcePath).bodyValue(
                new StreamListRequest(
                        this.requestHeaderFactory.streamList(
                                this.tokenService.getToken()
                        ),
                        body
                )
        ).retrieve().bodyToMono(
                StreamListResponse.class
        ).block();
    }
}
