package ir.rahyabcp.collector.service.internal.datanode.impl;

import ir.rahyabcp.collector.dataaccess.remote.node.dto.*;
import ir.rahyabcp.collector.model.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class DataNodeMapper {

    List<DataNode> fromGetDataNodeResponse(GetDataNodeResponse response) {
        return response.dataNodes().stream().map(
                this::fromDataNodeDto
        ).toList();
    }

    private DataNode fromDataNodeDto(DataNodeDto dto) {
        return switch (dto.getProtocol()) {
            case "DATABASE" -> fromDatabaseDataNodeDto((DatabaseDataNodeDto) dto);
            case "FTP" -> fromFtpDataNodeDto((FtpDataNodeDto) dto);
            case "REST" -> fromRestDataNodeDto((RestDataNodeDto) dto);
            case "WEB_SOCKET" -> fromWebSocketDataNodeDto((WebSocketDataNodeDto) dto);
            default -> throw new IllegalArgumentException("Unsupported protocol: " + dto.getProtocol());
        };
    }

    private DatabaseDataNode fromDatabaseDataNodeDto(DatabaseDataNodeDto dto) {
        throw new UnsupportedOperationException("Database collection not supported yet.");
    }

    private FtpDataNode fromFtpDataNodeDto(FtpDataNodeDto dto) {
        return new FtpDataNode.Builder()
                .host(dto.getHost())
                .port(dto.getPort())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .remotePath(dto.getRemotePath())
                .localPath(dto.getLocalPath())
                .filePattern(dto.getFilePattern())
                .build();
    }

    private RestDataNode fromRestDataNodeDto(RestDataNodeDto dto) {
        throw new UnsupportedOperationException("Rest collection not supported yet.");
    }

    private WebSocketDataNode fromWebSocketDataNodeDto(WebSocketDataNodeDto dto) {
        throw new UnsupportedOperationException("WebSocket collection not supported yet.");
    }
}
