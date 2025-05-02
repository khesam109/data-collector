package ir.rahyabcp.collector.dataaccess.remote.node.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class FtpDataNodeDto extends DataNodeDto {

    private final String host;
    private final int port;
    private final String username;
    private final String password;
    private final String remotePath;
    private final String localPath;
    private final String filePattern;

    public FtpDataNodeDto(
            @JsonProperty("host") String host,
            @JsonProperty("port") int port,
            @JsonProperty("username") String username,
            @JsonProperty("password") String password,
            @JsonProperty("remotePath") String remotePath,
            @JsonProperty("localPath") String localPath,
            @JsonProperty("filePattern") String filePattern
    ) {
        super("FTP");
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.remotePath = remotePath;
        this.localPath = localPath;
        this.filePattern = filePattern;
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

    public String getRemotePath() {
        return remotePath;
    }

    public String getLocalPath() {
        return localPath;
    }

    public String getFilePattern() {
        return filePattern;
    }
}
