package ir.rahyabcp.collector.service.configloader.local;

import ir.rahyabcp.collector.common.CollectorConfig;
import ir.rahyabcp.collector.service.configloader.ConfigLoader;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "config.source.type", havingValue = "default")
class DefaultConfigLoader implements ConfigLoader {

    @Override
    public CollectorConfig load() {
        throw new UnsupportedOperationException("this method is not implemented yet");
    }
}
