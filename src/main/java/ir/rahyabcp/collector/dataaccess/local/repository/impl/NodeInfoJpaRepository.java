package ir.rahyabcp.collector.dataaccess.local.repository.impl;

import ir.rahyabcp.collector.dataaccess.local.entity.NodeInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface NodeInfoJpaRepository extends JpaRepository<NodeInfoEntity, Integer> {
}
