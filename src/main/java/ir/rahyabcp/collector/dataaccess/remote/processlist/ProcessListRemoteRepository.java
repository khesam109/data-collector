package ir.rahyabcp.collector.dataaccess.remote.processlist;

import ir.rahyabcp.collector.dataaccess.remote.RequestHeaderFactory;
import ir.rahyabcp.collector.dataaccess.remote.processlist.dto.ProcessListRequest;
import ir.rahyabcp.collector.dataaccess.remote.processlist.dto.ProcessListRequestBody;
import ir.rahyabcp.collector.dataaccess.remote.processlist.dto.ProcessListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ProcessListRemoteRepository {

    private final WebClient webClient;
    private final String resourcePath;
    private final RequestHeaderFactory requestHeaderFactory;

    @Autowired
    public ProcessListRemoteRepository(
            WebClient webClient,
            String resourcePath,
            RequestHeaderFactory requestHeaderFactory
    ) {
        this.webClient = webClient;
        this.resourcePath = resourcePath;
        this.requestHeaderFactory = requestHeaderFactory;
    }

    public ProcessListResponse callProcessListApi(ProcessListRequestBody body) {
        return this.webClient.post().uri(resourcePath).bodyValue(
                new ProcessListRequest(
                        this.requestHeaderFactory.processList(),
                        body
                )
        ).retrieve().bodyToMono(
                ProcessListResponse.class
        ).block();
    }
}
