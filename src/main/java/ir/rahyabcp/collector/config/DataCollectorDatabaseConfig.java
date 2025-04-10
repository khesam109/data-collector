package ir.rahyabcp.collector.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableJpaRepositories(
        basePackages = {
                "ir.rahyabcp.collector.dataaccess.local.repository"
        },
        entityManagerFactoryRef = "dataCollectorEntityManagerFactory",
        transactionManagerRef = "dataCollectorTransactionManager"
)
class DataCollectorDatabaseConfig {

    private static final String DATA_COLLECTOR_ENTITIES_PACKAGE = "ir.rahyabcp.collector.dataaccess.local.entity";

    @Bean("dataCollectorDataSourceProperties")
    @ConfigurationProperties("spring.datasource.data-collector")
    DataSourceProperties dataCollectorDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean("dataCollectorDataSource")
    DataSource dataCollectorDataSource(
            @Qualifier("dataCollectorDataSourceProperties") DataSourceProperties dataCollectorDataSourceProperties
    ) {
        return dataCollectorDataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean("dataCollectorEntityManagerFactory")
    LocalContainerEntityManagerFactoryBean dataCollectorEntityManagerFactory(
            @Qualifier("dataCollectorDataSource") DataSource dataCollectorDataSource
    ) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataCollectorDataSource);
        factory.setPackagesToScan(DATA_COLLECTOR_ENTITIES_PACKAGE);
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return factory;
    }

    @Primary
    @Bean("dataCollectorTransactionManager")
    PlatformTransactionManager dataCollectorTransactionManager(
            @Qualifier("dataCollectorEntityManagerFactory") LocalContainerEntityManagerFactoryBean dataCollectorEntityManagerFactory
    ) {
        return new JpaTransactionManager(
                Objects.requireNonNull(
                        dataCollectorEntityManagerFactory.getObject()
                )
        );
    }
}
