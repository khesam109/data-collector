package ir.rahyabcp.collector.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@ConfigurationProperties(prefix = "authentication.info")
public class AuthenticationInfoConfig {

    private final String username;
    private final String password;
    private final String service;

    @ConstructorBinding
    public AuthenticationInfoConfig(String username, String password, String service) {
        this.username = username;
        this.password = password;
        this.service = service;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getService() {
        return service;
    }
}
