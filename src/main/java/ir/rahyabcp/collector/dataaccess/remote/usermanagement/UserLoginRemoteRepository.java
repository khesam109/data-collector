package ir.rahyabcp.collector.dataaccess.remote.usermanagement;

import ir.rahyabcp.collector.dataaccess.remote.RequestHeader;
import ir.rahyabcp.collector.dataaccess.remote.usermanagement.dto.UserLoginRequest;
import ir.rahyabcp.collector.dataaccess.remote.usermanagement.dto.UserLoginRequestBody;
import ir.rahyabcp.collector.dataaccess.remote.usermanagement.dto.UserLoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserLoginRemoteRepository {

    private final WebClient webClient;
    private final String resourcePath;

    @Autowired
    public UserLoginRemoteRepository(
            WebClient webClient,
            @Qualifier("resourcePath") String resourcePath
    ) {
        this.webClient = webClient;
        this.resourcePath = resourcePath;
    }

    public UserLoginResponse getToken(UserLoginRequestBody body, String publicToken) {
        return this.webClient.post().uri(resourcePath).bodyValue(
                new UserLoginRequest(
                        header(publicToken), body
                )
        ).retrieve().bodyToMono(
                UserLoginResponse.class
        ).block();
    }

    private RequestHeader header(String publicToken) {
        return new RequestHeader(publicToken, "sma.user_login", "20220601010203");
    }
}
