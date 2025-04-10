package ir.rahyabcp.collector.dataaccess.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

public final class NodeInfoEntity implements Serializable {

    private UUID id;
    private ConnectionProtocol connectionProtocol;
    private boolean active;
    private ZonedDateTime startPooling;
    private ZonedDateTime lastPooling;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ConnectionProtocol getConnectionProtocol() {
        return connectionProtocol;
    }

    public void setConnectionProtocol(ConnectionProtocol connectionProtocol) {
        this.connectionProtocol = connectionProtocol;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ZonedDateTime getStartPooling() {
        return startPooling;
    }

    public void setStartPooling(ZonedDateTime startPooling) {
        this.startPooling = startPooling;
    }

    public ZonedDateTime getLastPooling() {
        return lastPooling;
    }

    public void setLastPooling(ZonedDateTime lastPooling) {
        this.lastPooling = lastPooling;
    }
}
