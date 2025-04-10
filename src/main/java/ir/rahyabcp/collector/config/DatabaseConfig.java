package ir.rahyabcp.collector.config;

import ir.rahyabcp.collector.infrastructure.Database;
import ir.rahyabcp.collector.infrastructure.InMemoryDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
class DatabaseConfig {

    @Bean
    Database database() {
        return new InMemoryDatabase();
    }
}
