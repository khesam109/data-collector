package ir.rahyabcp.collector.service.internal.datanode.impl;

import ir.rahyabcp.collector.api.datanodelist.dto.DataNodeDto;
import ir.rahyabcp.collector.api.datanodelist.dto.DataNodeListResponse;
import ir.rahyabcp.collector.api.datanodelist.dto.FtpPropertiesDto;
import ir.rahyabcp.collector.common.ContentMode;
import ir.rahyabcp.collector.common.DataNodeStatus;
import ir.rahyabcp.collector.model.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class DataNodeMapper {

    List<DataNode> fromDataNodeListResponse(DataNodeListResponse response) {
        return response.getResponseBody().data().stream().map(
                this::fromDataNodeDto
        ).toList();
    }

    private DataNode fromDataNodeDto(DataNodeDto dataNodeDto) {
        return switch (dataNodeDto.protocol()) {
            case "DATABASE" -> fromDatabaseDataNodeDto(dataNodeDto);
            case "FTP" -> fromFtpDataNodeDto(dataNodeDto);
            case "REST" -> fromRestDataNodeDto(dataNodeDto);
            case "WEB_SOCKET" -> fromWebSocketDataNodeDto(dataNodeDto);
            default -> throw new IllegalArgumentException("Unsupported protocol: " + dataNodeDto.protocol());
        };
    }

    private DatabaseDataNode fromDatabaseDataNodeDto(DataNodeDto dataNodeDto) {
        throw new UnsupportedOperationException("Database collection not supported yet.");
    }

    //TODO: extended properties does not contain ftp port
    private FtpDataNode fromFtpDataNodeDto(DataNodeDto dataNodeDto) {
        FtpPropertiesDto ftpPropertiesDto = (FtpPropertiesDto) dataNodeDto.extendedProperties();
        return new FtpDataNode.Builder()
                .id(dataNodeDto.dataNodeId())
                .name(dataNodeDto.dataNodeName())
                .status(DataNodeStatus.fromString(dataNodeDto.dataNodeStatus()))
                .contentMode(ContentMode.fromString(dataNodeDto.contentMode()))
                .description(dataNodeDto.description())
                .host(ftpPropertiesDto.getFtpSourceIpv4())
                .port(22)
                .username(ftpPropertiesDto.getFtpUsername())
                .password(ftpPropertiesDto.getFtpPassword())
                .remotePath(ftpPropertiesDto.getFtpSourcePath())
                .localPath(ftpPropertiesDto.getFtpDestinationPath())
                .filePattern(ftpPropertiesDto.getFtpSourceMask())
                .build();
    }

    private RestDataNode fromRestDataNodeDto(DataNodeDto dataNodeDto) {
        throw new UnsupportedOperationException("Rest collection not supported yet.");
    }

    private WebSocketDataNode fromWebSocketDataNodeDto(DataNodeDto dataNodeDto) {
        throw new UnsupportedOperationException("WebSocket collection not supported yet.");
    }
}
