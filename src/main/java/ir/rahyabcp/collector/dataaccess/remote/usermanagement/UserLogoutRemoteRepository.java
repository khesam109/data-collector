package ir.rahyabcp.collector.dataaccess.remote.usermanagement;

import ir.rahyabcp.collector.dataaccess.remote.RequestHeader;
import ir.rahyabcp.collector.dataaccess.remote.usermanagement.dto.UserLogoutRequest;
import ir.rahyabcp.collector.service.internal.usermanagement.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserLogoutRemoteRepository {

    private final WebClient webClient;
    private final String resourcePath;
    private final TokenService tokenService;

    @Autowired
    public UserLogoutRemoteRepository(WebClient webClient, String resourcePath, TokenService tokenService) {
        this.webClient = webClient;
        this.resourcePath = resourcePath;
        this.tokenService = tokenService;
    }

    public void revokeToken() {
        this.webClient.post().uri(resourcePath).bodyValue(
                new UserLogoutRequest(
                        header(), null
                )
        ).retrieve().bodyToMono(
                Void.class
        ).block();
    }

    private RequestHeader header() {
        return new RequestHeader(
                this.tokenService.getToken(),
                "sma.user_login",
                "20220601010203"
        );
    }
}
