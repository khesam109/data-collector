package ir.rahyabcp.collector.service.internal.config.impl.rest;

import ir.rahyabcp.collector.config.ApplicationScheduleConfig;
import ir.rahyabcp.collector.dataaccess.remote._config.dto.ScheduleConfigResponse;
import org.springframework.stereotype.Component;

@Component
class RestConfigResponseMapper {

    ApplicationScheduleConfig fromScheduleConfigResponse(ScheduleConfigResponse response) {
        return new ApplicationScheduleConfig(
                response.interval()
        );
    }

//    ApplicationConfig fromRestConfigResponse(ConfigDto response) {
//        ApplicationConfig applicationConfig = new ApplicationConfig();
//
//        response.collectors().forEach(
//                e -> applicationConfig.addCollector(
//                        fromCollectorDto(e)
//                )
//        );
//
//        return applicationConfig;
//    }
//
//    private CollectorConfig fromCollectorDto(CollectorDto dto) {
//        return switch (dto.getProtocol()) {
//            case FTP -> this.fromFtpCollectorDto((FtpCollectorDto) dto);
//            case REST_API -> this.fromRestCollectorDto((RestCollectorDto) dto);
//            case DATABASE -> this.fromDatabaseCollectorDto((DatabaseCollectorDto) dto);
//            case WEB_SOCKET -> this.fromWebSocketCollectorDto((WebSocketCollectorDto) dto);
//        };
//    }
//
//    private FtpCollectorConfig fromFtpCollectorDto(FtpCollectorDto dto) {
//        return new FtpCollectorConfig(
//                getSchedulingConfig(dto.getScheduling()),
//                dto.getHost(),
//                dto.getPort(),
//                dto.getUsername(),
//                dto.getPassword()
//        );
//    }
//
//    private RestCollectorConfig fromRestCollectorDto(RestCollectorDto dto) {
//        throw new UnsupportedOperationException("this method is not implemented yet");
//    }
//
//    private DatabaseCollectorConfig fromDatabaseCollectorDto(DatabaseCollectorDto dto) {
//        throw new UnsupportedOperationException("this method is not implemented yet");
//    }
//
//    private WebSocketCollectorConfig fromWebSocketCollectorDto(WebSocketCollectorDto dto) {
//        throw new UnsupportedOperationException("this method is not implemented yet");
//    }
//
//    private SchedulingConfig getSchedulingConfig(SchedulingDto dto) {
//        return new SchedulingConfig(dto.interval(), dto.unit());
//    }
}
