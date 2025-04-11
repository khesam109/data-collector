package ir.rahyabcp.collector.dataaccess.local.entity;

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
class ScheduleInfoEntityTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void test_constraint_violation_exception_thrown_if_time_unit_is_null() {
        ScheduleInfoEntity scheduleInfo = new ScheduleInfoEntity();
        scheduleInfo.setPoolingInterval(1);
        scheduleInfo.setTimeUnit(null);

        assertThrows(PersistenceException.class, () -> entityManager.persist(scheduleInfo));
    }

    @Test
    void test_successful_insertion_when_constraints_are_met() {
        ScheduleInfoEntity scheduleInfo = new ScheduleInfoEntity();
        scheduleInfo.setPoolingInterval(1);
        scheduleInfo.setTimeUnit(TimeUnit.HOUR);

        assertDoesNotThrow( () -> entityManager.persist(scheduleInfo));
    }
}
