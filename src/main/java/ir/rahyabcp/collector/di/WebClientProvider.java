package ir.rahyabcp.collector.di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Component
class WebClientProvider {

    private static final String RESOURCE_PATH = "/saba/mrp/ws/usrequestex/";

    @Bean
    HttpClient provideHttpClient(
            @Value("${bss.url}") String url,
            @Value("${bss.port}") int port
    ) {
        return HttpClient.create()
                .baseUrl(url + ":" + port)
                .responseTimeout(Duration.ofSeconds(5))
                .disableRetry(true);
    }

    @Bean
    WebClient provideWebClient(
            HttpClient httpClient
    ) {
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024))
                .build();
    }

    @Bean("resourcePath")
    String provideResourcePath() {
        return RESOURCE_PATH;
    }
}
