package ir.rahyabcp.collector.service.internal.datanode.impl;

import ir.rahyabcp.collector.api.datanodelist.DataNodeListRemoteRepository;
import ir.rahyabcp.collector.api.datanodelist.dto.DataNodeListRequestBody;
import ir.rahyabcp.collector.api.datanodelist.dto.DataNodeListResponse;
import ir.rahyabcp.collector.config.ApplicationInfoConfig;
import ir.rahyabcp.collector.model.DataNode;
import ir.rahyabcp.collector.service.internal.datanode.DataNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class DataNodeServiceImpl implements DataNodeService {

    private final ApplicationInfoConfig applicationInfoConfig;
    private final DataNodeListRemoteRepository dataNodeListRemoteRepository;
    private final DataNodeMapper dataNodeMapper;

    @Autowired
    DataNodeServiceImpl(
            ApplicationInfoConfig applicationInfoConfig,
            DataNodeListRemoteRepository dataNodeListRemoteRepository,
            DataNodeMapper dataNodeMapper
    ) {
        this.applicationInfoConfig = applicationInfoConfig;
        this.dataNodeListRemoteRepository = dataNodeListRemoteRepository;
        this.dataNodeMapper = dataNodeMapper;
    }

    @Override
    public List<DataNode> getActiveDataNodes() {
        DataNodeListResponse response = this.dataNodeListRemoteRepository.callDataNodeListApi(
                new DataNodeListRequestBody(
                        this.applicationInfoConfig.getProcessId()
                )
        );
        return this.dataNodeMapper.fromDataNodeListResponse(
                response
        );
    }
}
