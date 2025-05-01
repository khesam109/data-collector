package ir.rahyabcp.collector.dataaccess.remote.config;

import ir.rahyabcp.collector.dataaccess.remote.config.dto.ScheduleConfigResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ScheduleConfigRemoteRepository {

    private static final String CONFIG_PATH = "/config";

    private final WebClient webClient;

    @Autowired
    public ScheduleConfigRemoteRepository(
            WebClient webClient
    ) {
        this.webClient = webClient;
    }

    public ScheduleConfigResponse fetch() {
        return this.webClient.get().uri(CONFIG_PATH).retrieve().bodyToMono(
                ScheduleConfigResponse.class
        ).block();
    }
}
