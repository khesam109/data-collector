package ir.rahyabcp.collector.dataaccess.remote.config;

import ir.rahyabcp.collector.dataaccess.remote.config.dto.ScheduleConfigResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ScheduleConfigRemoteRepository {

    private final String path;
    private final RestClient restClient;

    @Autowired
    public ScheduleConfigRemoteRepository(
            @Value("${config.source.rest.url}") String url,
            @Value("${config.source.rest.port}") int port,
            @Value("${config.source.rest.path}") String path
    ) {
        this.path = path;
        this.restClient = RestClient.builder().baseUrl(url + ":" + port).build();
    }

    public ScheduleConfigResponse fetch() {
        return this.restClient.get().uri(this.path).retrieve().body(
                ScheduleConfigResponse.class
        );
    }
}
