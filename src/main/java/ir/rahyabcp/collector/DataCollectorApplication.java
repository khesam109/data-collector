package ir.rahyabcp.collector;

import ir.rahyabcp.collector.config.ApplicationInfoConfig;
import ir.rahyabcp.collector.config.AuthenticationInfoConfig;
import ir.rahyabcp.collector.config.SystemInfoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableRetry
@EnableConfigurationProperties({
		ApplicationInfoConfig.class,
        AuthenticationInfoConfig.class,
        SystemInfoConfig.class
})
@SpringBootApplication
public class DataCollectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataCollectorApplication.class, args);
	}

}
