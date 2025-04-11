package ir.rahyabcp.collector.dataaccess.local.entity;

import ir.rahyabcp.collector.common.ConnectionProtocol;
import ir.rahyabcp.collector.common.TimeUnit;
import jakarta.persistence.PersistenceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@ActiveProfiles("test")
class NodeInfoEntityTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void test_constraint_violation_exception_thrown_if_connection_protocol_is_null() {
        NodeInfoEntity nodeInfo = new NodeInfoEntity();
        nodeInfo.setConnectionProtocol(null);
        nodeInfo.addScheduleInfo(1, TimeUnit.HOUR);

        assertThrows(PersistenceException.class, () -> entityManager.persist(nodeInfo));
    }

    @Test
    void test_constraint_violation_exception_thrown_if_schedule_info_id_is_null() {
        NodeInfoEntity nodeInfo = new NodeInfoEntity();
        nodeInfo.setConnectionProtocol(ConnectionProtocol.FTP);

        assertThrows(PersistenceException.class, () -> entityManager.persist(nodeInfo));
    }

    @Test
    void test_successful_insertion_when_constraints_are_met() {
        NodeInfoEntity nodeInfo = new NodeInfoEntity();
        nodeInfo.setConnectionProtocol(ConnectionProtocol.FTP);
        nodeInfo.addScheduleInfo(1, TimeUnit.HOUR);

        assertDoesNotThrow( () -> entityManager.persist(nodeInfo));
    }
}
