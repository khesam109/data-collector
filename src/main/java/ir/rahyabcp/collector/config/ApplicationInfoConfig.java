package ir.rahyabcp.collector.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@ConfigurationProperties(prefix = "application.info")
public class ApplicationInfoConfig {

    private final Integer processId;

    @ConstructorBinding
    public ApplicationInfoConfig(Integer processId) {
        this.processId = processId;
    }

    public Integer getProcessId() {
        return processId;
    }
}
