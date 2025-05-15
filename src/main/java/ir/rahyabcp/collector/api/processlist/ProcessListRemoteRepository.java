package ir.rahyabcp.collector.api.processlist;

import ir.rahyabcp.collector.api.RequestHeaderFactory;
import ir.rahyabcp.collector.api.processlist.dto.ProcessListRequest;
import ir.rahyabcp.collector.api.processlist.dto.ProcessListRequestBody;
import ir.rahyabcp.collector.api.processlist.dto.ProcessListResponse;
import ir.rahyabcp.collector.service.internal.usermanagement.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ProcessListRemoteRepository {

    private final WebClient webClient;
    private final String resourcePath;
    private final RequestHeaderFactory requestHeaderFactory;
    private final TokenService tokenService;

    @Autowired
    public ProcessListRemoteRepository(
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

    public ProcessListResponse callProcessListApi(ProcessListRequestBody body) {
        return this.webClient.post().uri(resourcePath).bodyValue(
                new ProcessListRequest(
                        this.requestHeaderFactory.processList(
                                this.tokenService.getToken()
                        ),
                        body
                )
        ).retrieve().bodyToMono(
                ProcessListResponse.class
        ).block();
    }
}
