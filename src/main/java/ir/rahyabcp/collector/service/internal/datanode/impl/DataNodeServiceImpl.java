package ir.rahyabcp.collector.service.internal.datanode.impl;

import ir.rahyabcp.collector.dataaccess.remote.node.DataNodeRemoteRepository;
import ir.rahyabcp.collector.model.DataNode;
import ir.rahyabcp.collector.service.internal.datanode.DataNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class DataNodeServiceImpl implements DataNodeService {

    private final DataNodeRemoteRepository dataNodeRemoteRepository;
    private final DataNodeMapper dataNodeMapper;

    @Autowired
    DataNodeServiceImpl(
            DataNodeRemoteRepository dataNodeRemoteRepository,
            DataNodeMapper dataNodeMapper
    ) {
        this.dataNodeRemoteRepository = dataNodeRemoteRepository;
        this.dataNodeMapper = dataNodeMapper;
    }

    @Override
    public List<DataNode> getActiveDataNodes() {
        return this.dataNodeMapper.fromGetDataNodeResponse(
                this.dataNodeRemoteRepository.fetch()
        );
    }
}
