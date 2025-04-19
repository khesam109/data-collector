package ir.rahyabcp.collector.service.internal.config.impl;

import ir.rahyabcp.collector.dataaccess.local.repository.NodeInfoRepository;
import ir.rahyabcp.collector.model.ApplicationConfig;
import ir.rahyabcp.collector.service.internal.config.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class ConfigServiceImpl implements ConfigService {

    private final NodeInfoRepository nodeInfoRepository;

    @Autowired
    public ConfigServiceImpl(
            NodeInfoRepository nodeInfoRepository
    ) {
        this.nodeInfoRepository = nodeInfoRepository;
    }

    public void persistConfig(ApplicationConfig config) {

    }
}
