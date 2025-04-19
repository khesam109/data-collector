package ir.rahyabcp.collector.service.internal.config.impl.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.rahyabcp.collector.common.ConnectionProtocol;

public final class FtpCollectorDto extends CollectorDto {

    private final String host;
    private final int port;
    private final String username;
    private final String password;

    @JsonCreator
    public FtpCollectorDto(
            @JsonProperty("scheduling") SchedulingDto scheduling,
            @JsonProperty("host") String host,
            @JsonProperty("port") int port,
            @JsonProperty("username") String username,
            @JsonProperty("password") String password
    ) {
        super(ConnectionProtocol.FTP, scheduling);
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

