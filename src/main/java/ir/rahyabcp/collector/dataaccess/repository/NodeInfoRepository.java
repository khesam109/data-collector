package ir.rahyabcp.collector.dataaccess.repository;

import ir.rahyabcp.collector.dataaccess.entity.NodeInfoEntity;

public interface NodeInfoRepository {

    int saveNode(NodeInfoEntity node);
    NodeInfoEntity findById(int id);
    void updateNode(NodeInfoEntity node);
}
