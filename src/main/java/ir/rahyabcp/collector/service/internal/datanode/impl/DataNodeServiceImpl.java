package ir.rahyabcp.collector.service.internal.datanode.impl;

import ir.rahyabcp.collector.api.datanodelist.DataNodeListRemoteRepository;
import ir.rahyabcp.collector.model.DataNode;
import ir.rahyabcp.collector.service.internal.datanode.DataNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class DataNodeServiceImpl implements DataNodeService {

    private final DataNodeListRemoteRepository dataNodeListRemoteRepository;
//    private final DataNodeMapper dataNodeMapper;

    @Autowired
    DataNodeServiceImpl(
            DataNodeListRemoteRepository dataNodeListRemoteRepository
//            DataNodeMapper dataNodeMapper
    ) {
        this.dataNodeListRemoteRepository = dataNodeListRemoteRepository;
//        this.dataNodeMapper = dataNodeMapper;
    }

    @Override
    public List<DataNode> getActiveDataNodes() {
        return null;
//        return this.dataNodeMapper.fromGetDataNodeResponse(
//                this.dataNodeListRemoteRepository.fetch()
//        );
    }
}
