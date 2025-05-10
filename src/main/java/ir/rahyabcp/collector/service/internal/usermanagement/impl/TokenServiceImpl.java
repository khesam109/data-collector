package ir.rahyabcp.collector.service.internal.usermanagement.impl;

import ir.rahyabcp.collector.dataaccess.remote.usermanagement.ConfigListRemoteRepository;
import ir.rahyabcp.collector.dataaccess.remote.usermanagement.UserLoginRemoteRepository;
import ir.rahyabcp.collector.dataaccess.remote.usermanagement.dto.ConfigListRequestBody;
import ir.rahyabcp.collector.dataaccess.remote.usermanagement.dto.ConfigListResponse;
import ir.rahyabcp.collector.dataaccess.remote.usermanagement.dto.UserLoginRequestBody;
import ir.rahyabcp.collector.dataaccess.remote.usermanagement.dto.UserLoginResponse;
import ir.rahyabcp.collector.service.internal.usermanagement.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
class TokenServiceImpl implements TokenService {

    private final AtomicReference<String> TOKEN = new AtomicReference<>();

    private final ConfigListRemoteRepository configListRemoteRepository;
    private final UserLoginRemoteRepository userLoginRemoteRepository;
    private final String username;
    private final String password;
    private final String service;

    @Autowired
    TokenServiceImpl(
            ConfigListRemoteRepository configListRemoteRepository,
            UserLoginRemoteRepository userLoginRemoteRepository,
            @Value("${authentication.username}") String username,
            @Value("${authentication.password}") String password,
            @Value("${authentication.service}") String service
    ) {
        this.configListRemoteRepository = configListRemoteRepository;
        this.userLoginRemoteRepository = userLoginRemoteRepository;
        this.username = username;
        this.password = password;
        this.service = service;
    }

    @Override
    public void login() {
        String publicToken = this.getPublicToken();
        String accessToken = this.getAccessToken(publicToken);
        TOKEN.set(accessToken);
    }

    @Override
    public String getToken() {
        return TOKEN.get();
    }

    private String getPublicToken() {
        ConfigListResponse configListResponse = this.configListRemoteRepository.getPublicToken(
                new ConfigListRequestBody(
                        "desktop",
                        "Windows10",
                        "Chrome",
                        1006,
                        "1.0",
                        "",
                        1001,
                        1001,
                        new ConfigListRequestBody.Partner("", ""),
                        List.of(),
                        "EN"
                )
        );

        return configListResponse.getResponseBody().publicToken();
    }

    private String getAccessToken(String publicToken) {
        UserLoginResponse userLoginResponse = this.userLoginRemoteRepository.getToken(
                new UserLoginRequestBody(
                        new UserLoginRequestBody.Authentication(
                                this.username,
                                this.password,
                                this.service
                        )
                ),
                publicToken
        );

        return userLoginResponse.getResponseBody().token();
    }
}
