package ir.rahyabcp.collector.dataaccess.local.repository.impl;

import ir.rahyabcp.collector.dataaccess.local.entity.NodeInfoEntity;
import ir.rahyabcp.collector.dataaccess.local.repository.NodeInfoRepository;
import ir.rahyabcp.collector.exception.impl.NodeInfoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class NodeInfoRepositoryImpl implements NodeInfoRepository {

    private final NodeInfoJpaRepository nodeInfoJpaRepository;

    @Autowired
    public NodeInfoRepositoryImpl(
            NodeInfoJpaRepository nodeInfoJpaRepository
    ) {
        this.nodeInfoJpaRepository = nodeInfoJpaRepository;
    }

    @Override
    public NodeInfoEntity saveNodeInfo(NodeInfoEntity nodeInfo) {
        return this.nodeInfoJpaRepository.save(nodeInfo);
    }

    @Override
    public List<NodeInfoEntity> findAll() {
        return this.nodeInfoJpaRepository.findAll();
    }

    @Override
    public NodeInfoEntity findById(int id) {
        return this.nodeInfoJpaRepository.findById(id).orElseThrow(
                () -> new NodeInfoNotFoundException("node info with id " + id + " not found")
        );
    }

    @Override
    public void updateNodeInfo(NodeInfoEntity nodeInfo) {
        if (this.nodeInfoJpaRepository.existsById(nodeInfo.getId()))
            this.nodeInfoJpaRepository.save(nodeInfo);
    }
}
