package ir.rahyabcp.collector.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ConditionalOnProperty(name = "spring.datasource.data-collector.liquibase.enabled", havingValue = "true")
class DataCollectorLiquibaseConfig {

    @Bean("dataCollectorLiquibaseProperties")
    @ConfigurationProperties("spring.datasource.data-collector.liquibase")
    LiquibaseProperties dataCollectorLiquibaseProperties() {
        return new LiquibaseProperties();
    }


    @Bean("dataCollectorLiquibase")
    SpringLiquibase dataCollectorLiquibase(
            @Qualifier("dataCollectorLiquibaseProperties") LiquibaseProperties liquibaseProperties,
            @Qualifier("dataCollectorDataSource") DataSource dataCollectorDataSource
    ) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(DataSourceBuilder.create().build());
        liquibase.setDataSource(dataCollectorDataSource);
        liquibase.setChangeLog(liquibaseProperties.getChangeLog());
        liquibase.setContexts(String.join(",", liquibaseProperties.getContexts()));
        liquibase.setDefaultSchema(liquibaseProperties.getDefaultSchema());
        liquibase.setLiquibaseSchema(liquibaseProperties.getLiquibaseSchema());
        liquibase.setDropFirst(liquibaseProperties.isDropFirst());
        liquibase.setShouldRun(liquibaseProperties.isEnabled());

        return liquibase;
    }
}
