package ir.rahyabcp.collector.dataaccess.local.repository.nodeinfo;

import ir.rahyabcp.collector.dataaccess.local.entity.NodeInfoEntity;

import java.util.List;

public interface NodeInfoRepository {

    NodeInfoEntity saveNodeInfo(NodeInfoEntity nodeInfo);
    List<NodeInfoEntity> findAll();
    NodeInfoEntity findById(int id);
    void updateNodeInfo(NodeInfoEntity nodeInfo);
}
