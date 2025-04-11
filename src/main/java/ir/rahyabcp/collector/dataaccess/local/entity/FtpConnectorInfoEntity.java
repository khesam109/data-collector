package ir.rahyabcp.collector.dataaccess.local.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "FTP_CONNECTOR_INFO", schema = "DATA_COLLECTOR")
public class FtpConnectorInfoEntity {

    @Id
    @Column(name = "ID", nullable = false)
    @SequenceGenerator(name = "ftpConnectorInfoSequenceGenerator", sequenceName = "FTP_CONNECTOR_INFO_SEQ", allocationSize = 1, schema = "DATA_COLLECTOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ftpConnectorInfoSequenceGenerator")
    private int id;

    @Column(name = "HOST", nullable = false)
    private String host;

    @Column(name = "PORT", nullable = false)
    private int port;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "REMOTE_DIRECTORY", nullable = false)
    private String remoteDirectory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemoteDirectory() {
        return remoteDirectory;
    }

    public void setRemoteDirectory(String remoteDirectory) {
        this.remoteDirectory = remoteDirectory;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;

        if (!(o instanceof FtpConnectorInfoEntity that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
