package ir.rahyabcp.collector.service.configloader.rest;

import ir.rahyabcp.collector.common.CollectorConfig;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
class ConfigRestResponseMapper {

    CollectorConfig fromRestCollectorConfigResponse(Map<String, Object> response) {
        return new CollectorConfig();
    }
}
