package ir.rahyabcp.collector.model;

import java.util.ArrayList;
import java.util.List;

public class ApplicationConfig {

    private final List<CollectorConfig> collectors;

    public ApplicationConfig() {
        this.collectors = new ArrayList<>();
    }

    public void addCollector(CollectorConfig collector) {
        this.collectors.add(collector);
    }

    public List<CollectorConfig> getCollectors() {
        return collectors;
    }
}
