package ir.rahyabcp.collector.service.internal.config.impl.defaults;

import ir.rahyabcp.collector.config.ApplicationScheduleConfig;
import ir.rahyabcp.collector.service.internal.config.ConfigLoader;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "config.source.type", havingValue = "default")
class DefaultConfigLoader implements ConfigLoader {

    @Override
    public ApplicationScheduleConfig load() {
        throw new UnsupportedOperationException("this method is not implemented yet");
    }
}
