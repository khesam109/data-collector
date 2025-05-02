package ir.rahyabcp.collector.dataaccess.remote.node;

import ir.rahyabcp.collector.dataaccess.remote.node.dto.GetDataNodeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class DataNodeRemoteRepository {

    private static final String DATA_NODES_PATH = "/data-nodes";

    private final WebClient webClient;

    @Autowired
    public DataNodeRemoteRepository(WebClient webClient) {
        this.webClient = webClient;
    }

    public GetDataNodeResponse fetch() {
        return this.webClient.get().uri(DATA_NODES_PATH).retrieve().bodyToMono(
                GetDataNodeResponse.class
        ).block();
    }
}
