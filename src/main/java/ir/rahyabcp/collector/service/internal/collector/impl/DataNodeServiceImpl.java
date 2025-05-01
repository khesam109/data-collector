package ir.rahyabcp.collector.service.internal.collector.impl;

import ir.rahyabcp.collector.model.DataNode;
import ir.rahyabcp.collector.model.FtpDataNode;
import ir.rahyabcp.collector.service.internal.collector.DataNodeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class DataNodeServiceImpl implements DataNodeService {

    @Override
    public List<DataNode> getActiveDataNodes() {
        return List.of(
                new FtpDataNode.Builder()
                        .host("host1")
                        .port(123)
                        .username("user1")
                        .password("pass1")
                        .localPath("local1")
                        .remotePath("remote1")
                        .build(),
                new FtpDataNode.Builder()
                        .host("host2")
                        .port(321)
                        .username("user2")
                        .password("pass2")
                        .localPath("local2")
                        .remotePath("remote2")
                        .build()
        );
    }
}
