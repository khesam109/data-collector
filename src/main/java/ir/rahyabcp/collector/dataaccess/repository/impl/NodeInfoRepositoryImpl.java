package ir.rahyabcp.collector.dataaccess.repository.impl;

import ir.rahyabcp.collector.dataaccess.entity.NodeInfoEntity;
import ir.rahyabcp.collector.dataaccess.repository.NodeInfoRepository;
import ir.rahyabcp.collector.exception.impl.NodeInfoNotFoundException;
import ir.rahyabcp.collector.infrastructure.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
class NodeInfoRepositoryImpl implements NodeInfoRepository {

    private static final String TABLE_NAME = "NODES";

    private final Database database;

    @Autowired
    public NodeInfoRepositoryImpl(Database database) {
        this.database = database;
    }

    @Override
    public int saveNode(NodeInfoEntity node) {
        return this.database.insert(TABLE_NAME, node);
    }

    @Override
    public NodeInfoEntity findById(int id) {
        return (NodeInfoEntity) this.database.select(
                TABLE_NAME, id
        ).orElseThrow(
                () -> new NodeInfoNotFoundException("node info not found with id: " + id)
        );
    }

    @Override
    public void updateNode(NodeInfoEntity node) {
        this.database.update(TABLE_NAME, node);
    }
}
