package ir.rahyabcp.collector.dataaccess.remote.userlogout;

import ir.rahyabcp.collector.dataaccess.remote.RequestHeaderFactory;
import ir.rahyabcp.collector.dataaccess.remote.userlogout.dto.UserLogoutRequest;
import ir.rahyabcp.collector.service.internal.usermanagement.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserLogoutRemoteRepository {

    private final WebClient webClient;
    private final String resourcePath;
    private final RequestHeaderFactory requestHeaderFactory;
    private final TokenService tokenService;

    @Autowired
    public UserLogoutRemoteRepository(
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

    public void callUserLogoutApi() {
        this.webClient.post().uri(resourcePath).bodyValue(
                new UserLogoutRequest(
                        this.requestHeaderFactory.userLogout(
                                this.tokenService.getToken()
                        ),
                        null
                )
        ).retrieve().bodyToMono(
                Void.class
        ).block();
    }
}
