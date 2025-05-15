package ir.rahyabcp.collector.dataaccess.remote;

import ir.rahyabcp.collector.service.internal.usermanagement.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class RequestHeaderFactory {

    private final TokenService tokenService;
    private final DateTimeFormatter dateTimeFormatter;

    @Autowired
    public RequestHeaderFactory(
            TokenService tokenService,
            DateTimeFormatter dateTimeFormatter
    ) {
        this.tokenService = tokenService;
        this.dateTimeFormatter = dateTimeFormatter;
    }

    public RequestHeader configList() {
        return new RequestHeader(
                null,
                "sma.config_list",
                this.systemDate()
        );
    }

    public RequestHeader userLogin(String publicToken) {
        return new RequestHeader(
                publicToken,
                "sma.user_login",
                this.systemDate()
        );
    }

    public RequestHeader userLogout() {
        return new RequestHeader(
                this.tokenService.getToken(),
                "sma.sma.user_logout",
                this.systemDate()
        );
    }

    private String systemDate() {
        return LocalDateTime.now().format(this.dateTimeFormatter);
    }
}
