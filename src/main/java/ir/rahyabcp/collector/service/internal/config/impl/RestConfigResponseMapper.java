package ir.rahyabcp.collector.service.internal.config.impl;

import ir.rahyabcp.collector.common.DataCollectorConfig;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
class RestConfigResponseMapper {

    DataCollectorConfig fromRestConfigResponse(Map<String, Object> response) {
        return new DataCollectorConfig();
    }
}
