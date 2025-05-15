package ir.rahyabcp.collector.service.internal.usermanagement.impl;

import ir.rahyabcp.collector.api.configlist.ConfigListRemoteRepository;
import ir.rahyabcp.collector.api.configlist.dto.ConfigListRequestBody;
import ir.rahyabcp.collector.api.configlist.dto.ConfigListResponse;
import ir.rahyabcp.collector.api.configlist.dto.PartnerDto;
import ir.rahyabcp.collector.api.userlogin.UserLoginRemoteRepository;
import ir.rahyabcp.collector.api.userlogin.dto.AuthenticationDto;
import ir.rahyabcp.collector.api.userlogin.dto.UserLoginRequestBody;
import ir.rahyabcp.collector.api.userlogin.dto.UserLoginResponse;
import ir.rahyabcp.collector.config.AuthenticationInfoConfig;
import ir.rahyabcp.collector.config.SystemInfoConfig;
import ir.rahyabcp.collector.service.internal.usermanagement.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

@Service
class TokenServiceImpl implements TokenService {

    private final AtomicReference<String> TOKEN = new AtomicReference<>();

    private final ConfigListRemoteRepository configListRemoteRepository;
    private final UserLoginRemoteRepository userLoginRemoteRepository;
    private final AuthenticationInfoConfig authenticationInfoConfig;
    private final SystemInfoConfig systemInfoConfig;

    @Autowired
    TokenServiceImpl(
            ConfigListRemoteRepository configListRemoteRepository,
            UserLoginRemoteRepository userLoginRemoteRepository,
            AuthenticationInfoConfig authenticationInfoConfig,
            SystemInfoConfig systemInfoConfig
    ) {
        this.configListRemoteRepository = configListRemoteRepository;
        this.userLoginRemoteRepository = userLoginRemoteRepository;
        this.authenticationInfoConfig = authenticationInfoConfig;
        this.systemInfoConfig = systemInfoConfig;
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
        ConfigListResponse configListResponse = this.configListRemoteRepository.callConfigListApi(
                new ConfigListRequestBody(
                        this.systemInfoConfig.getDeviceType(),
                        this.systemInfoConfig.getOs(),
                        this.systemInfoConfig.getBrowser(),
                        this.systemInfoConfig.getChannelId(),
                        this.systemInfoConfig.getChannelVersion(),
                        this.systemInfoConfig.getDeviceId(),
                        this.systemInfoConfig.getSystemId(),
                        this.systemInfoConfig.getBusinessCenterId(),
                        new PartnerDto(
                                this.systemInfoConfig.getPartnerDomain(),
                                this.systemInfoConfig.getPartnerToken()
                        ),
                        this.systemInfoConfig.getTechnologies(),
                        this.systemInfoConfig.getLanguageCode()
                )
        );

        return configListResponse.getResponseBody().publicToken();
    }

    private String getAccessToken(String publicToken) {
        UserLoginResponse userLoginResponse = this.userLoginRemoteRepository.callUserLoginApi(
                new UserLoginRequestBody(
                        new AuthenticationDto(
                                this.authenticationInfoConfig.getUsername(),
                                this.authenticationInfoConfig.getPassword(),
                                this.authenticationInfoConfig.getService()
                        )
                ),
                publicToken
        );

        return userLoginResponse.getResponseBody().token();
    }
}
