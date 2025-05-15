package ir.rahyabcp.collector.di;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
class DateTimeFormatterProvider {

    @Bean
    DateTimeFormatter provideDateTimeFormatter() {
        return DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    }
}
