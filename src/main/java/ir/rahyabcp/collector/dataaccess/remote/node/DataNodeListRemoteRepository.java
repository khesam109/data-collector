package ir.rahyabcp.collector.dataaccess.remote.node;

import ir.rahyabcp.collector.dataaccess.remote.RequestHeader;
import ir.rahyabcp.collector.dataaccess.remote.node.dto.rebrand.DataNodeListRequest;
import ir.rahyabcp.collector.dataaccess.remote.node.dto.rebrand.DataNodeListRequestBody;
import ir.rahyabcp.collector.dataaccess.remote.node.dto.rebrand.DataNodeListResponse;
import ir.rahyabcp.collector.service.internal.usermanagement.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class DataNodeListRemoteRepository {

    private final WebClient webClient;
    private final String resourcePath;
    private final TokenService tokenService;
    private final int processId;

    @Autowired
    public DataNodeListRemoteRepository(
            WebClient webClient,
            String resourcePath,
            TokenService tokenService,
            @Value("${spring.application.process-id}") int processId
    ) {
        this.webClient = webClient;
        this.resourcePath = resourcePath;
        this.tokenService = tokenService;
        this.processId = processId;
    }

    public DataNodeListResponse fetch() {
        return this.webClient.post().uri(resourcePath).bodyValue(
                new DataNodeListRequest(header(), body())
        ).retrieve().bodyToMono(
                DataNodeListResponse.class
        ).block();
    }

    private DataNodeListRequestBody body() {
        return new DataNodeListRequestBody(processId);
    }

    private RequestHeader header() {
        return new RequestHeader(
                this.tokenService.getToken(),
                "dpa.datanode_list",
                "20220601010203"
        );
    }
}
