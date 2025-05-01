package ir.rahyabcp.collector.dataaccess.remote.node.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public final class WebSocketDataNodeDto extends DataNodeDto {

    @JsonCreator
    public WebSocketDataNodeDto() {
        super("WEB_SOCKET");
    }
}
