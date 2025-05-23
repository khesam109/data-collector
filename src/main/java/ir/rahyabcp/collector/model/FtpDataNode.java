package ir.rahyabcp.collector.model;

import ir.rahyabcp.collector.common.ConnectionProtocol;
import ir.rahyabcp.collector.common.ContentMode;
import ir.rahyabcp.collector.common.DataNodeStatus;

public class FtpDataNode extends DataNode {

    private final String host;
    private final int port;
    private final String username;
    private final String password;
    private final String remotePath;
    private final String localPath;
    private final String filePattern;

    private FtpDataNode(Builder builder) {
        super(builder.id, builder.name, builder.status, builder.contentMode, ConnectionProtocol.FTP, builder.description, null, null);
        this.host = builder.host;
        this.port = builder.port;
        this.username = builder.username;
        this.password = builder.password;
        this.remotePath = builder.remotePath;
        this.localPath = builder.localPath;
        this.filePattern = builder.filePattern;
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

    public static final class Builder {
        private Integer id = null;
        private String name = null;
        private DataNodeStatus status = null;
        private ContentMode contentMode = null;
        private String description = null;
        private String host = null;
        private Integer port = null;
        private String username = null;
        private String password = null;
        private String remotePath = null;
        private String localPath = null;
        private String filePattern = null;

        public Builder() {
        }

        public Builder id(Integer val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder status(DataNodeStatus val) {
            status = val;
            return this;
        }

        public Builder contentMode(ContentMode val) {
            contentMode = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
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

        public Builder filePattern(String val) {
            filePattern = val;
            return this;
        }

        public FtpDataNode build() {
            if (id == null || name == null || status == null || contentMode == null || host == null || port == null ||
                    username == null || password == null || remotePath == null || localPath == null || filePattern == null
            ) {
                throw new IllegalStateException("Not all required fields are set");
            }
            return new FtpDataNode(this);
        }
    }

    @Override
    public String toString() {
        return "FtpDataNode{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", remotePath='" + remotePath + '\'' +
                ", localPath='" + localPath + '\'' +
                ", filePattern='" + filePattern + '\'' +
                '}';
    }
}
