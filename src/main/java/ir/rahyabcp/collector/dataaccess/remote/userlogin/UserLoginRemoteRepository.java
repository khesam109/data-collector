package ir.rahyabcp.collector.dataaccess.remote.userlogin;

import ir.rahyabcp.collector.dataaccess.remote.RequestHeaderFactory;
import ir.rahyabcp.collector.dataaccess.remote.userlogin.dto.UserLoginRequest;
import ir.rahyabcp.collector.dataaccess.remote.userlogin.dto.UserLoginRequestBody;
import ir.rahyabcp.collector.dataaccess.remote.userlogin.dto.UserLoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserLoginRemoteRepository {

    private final WebClient webClient;
    private final String resourcePath;
    private final RequestHeaderFactory requestHeaderFactory;

    @Autowired
    public UserLoginRemoteRepository(
            WebClient webClient,
            @Qualifier("resourcePath") String resourcePath,
            RequestHeaderFactory requestHeaderFactory
    ) {
        this.webClient = webClient;
        this.resourcePath = resourcePath;
        this.requestHeaderFactory = requestHeaderFactory;
    }

    public UserLoginResponse getToken(UserLoginRequestBody body, String publicToken) {
        return this.webClient.post().uri(resourcePath).bodyValue(
                new UserLoginRequest(
                        this.requestHeaderFactory.userLogin(publicToken),
                        body
                )
        ).retrieve().bodyToMono(
                UserLoginResponse.class
        ).block();
    }
}
