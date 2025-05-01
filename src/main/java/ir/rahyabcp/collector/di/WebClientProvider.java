package ir.rahyabcp.collector.di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
class WebClientProvider {

    @Bean
    WebClient provideWebClient(
            @Value("${bss.url}") String url,
            @Value("${bss.port}") int port
    ) {
        return WebClient.builder()
                .baseUrl(url + ":" + port)
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024))
                .build();
    }
}
