package ir.rahyabcp.collector.dataaccess.remote.userlogout;

import ir.rahyabcp.collector.dataaccess.remote.RequestHeaderFactory;
import ir.rahyabcp.collector.dataaccess.remote.userlogout.dto.UserLogoutRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserLogoutRemoteRepository {

    private final WebClient webClient;
    private final String resourcePath;
    private final RequestHeaderFactory requestHeaderFactory;

    @Autowired
    public UserLogoutRemoteRepository(
            WebClient webClient,
            String resourcePath,
            RequestHeaderFactory requestHeaderFactory
    ) {
        this.webClient = webClient;
        this.resourcePath = resourcePath;
        this.requestHeaderFactory = requestHeaderFactory;
    }

    public void callUserLogoutApi() {
        this.webClient.post().uri(resourcePath).bodyValue(
                new UserLogoutRequest(
                        this.requestHeaderFactory.userLogout(),
                        null
                )
        ).retrieve().bodyToMono(
                Void.class
        ).block();
    }
}
