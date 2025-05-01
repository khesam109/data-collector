package ir.rahyabcp.collector.service.internal.collector.impl;

import ir.rahyabcp.collector.model.DataNode;
import ir.rahyabcp.collector.service.internal.collector.CollectionService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class CollectionServiceImpl implements CollectionService {

    @Override
    @Async("dataCollectionTaskExecutor")
    public void collect(DataNode dataNode) {
        System.out.println(Thread.currentThread().getName() + " : " + dataNode.toString());
    }
}
