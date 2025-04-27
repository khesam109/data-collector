package ir.rahyabcp.collector.service.internal.config;

import ir.rahyabcp.collector.model.ApplicationConfig;

public interface ConfigStoreService {

    void persistConfig(ApplicationConfig config);
}
