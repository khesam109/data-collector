package ir.rahyabcp.collector.model;

import ir.rahyabcp.collector.common.ConnectionProtocol;

public class FtpDataNode extends DataNode {

    private final String host;
    private final int port;
    private final String username;
    private final String password;
    private final String remotePath;
    private final String localPath;

    private FtpDataNode(Builder builder) {
        super(ConnectionProtocol.FTP, null);
        this.host = builder.host;
        this.port = builder.port;
        this.username = builder.username;
        this.password = builder.password;
        this.remotePath = builder.remotePath;
        this.localPath = builder.localPath;
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

    public static final class Builder {
        private String host = null;
        private Integer port = null;
        private String username = null;
        private String password = null;
        private String remotePath = null;
        private String localPath = null;

        public Builder() {
        }

        public Builder host(String val) {
            host = val;
            return this;
        }

        public Builder port(Integer val) {
            port = val;
            return this;
        }

        public Builder username(String val) {
            username = val;
            return this;
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public Builder remotePath(String val) {
            remotePath = val;
            return this;
        }

        public Builder localPath(String val) {
            localPath = val;
            return this;
        }

        public FtpDataNode build() {
            if (host == null || port == null || username == null || password == null || remotePath == null || localPath == null) {
                throw new IllegalStateException("Not all required fields are set");
            }
            return new FtpDataNode(this);
        }
    }
}
