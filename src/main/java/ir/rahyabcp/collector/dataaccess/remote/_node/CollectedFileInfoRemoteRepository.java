package ir.rahyabcp.collector.dataaccess.remote._node;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CollectedFileInfoRemoteRepository {

    private static final String COLLECTED_FILES_PATH = "/collected-files";

    private final WebClient webClient;

    @Autowired
    public CollectedFileInfoRemoteRepository(WebClient webClient) {
        this.webClient = webClient;
    }

    public CollectedFileInfoResponse fetch() {
        return this.webClient.get().uri(COLLECTED_FILES_PATH).retrieve().bodyToMono(
                CollectedFileInfoResponse.class
        ).block();
    }
}
