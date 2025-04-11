package ir.rahyabcp.collector.dataaccess.local.entity;

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
class FtpConnectorInfoEntityTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void test_constraint_violation_exception_thrown_if_host_is_null() {
        FtpConnectorInfoEntity ftpConnectorInfo = new FtpConnectorInfoEntity();
        ftpConnectorInfo.setHost(null);
        ftpConnectorInfo.setPort(21);
        ftpConnectorInfo.setUsername("username");
        ftpConnectorInfo.setPassword("password");
        ftpConnectorInfo.setRemoteDirectory("remote");

        assertThrows(PersistenceException.class, () -> entityManager.persist(ftpConnectorInfo));
    }

    @Test
    void test_constraint_violation_exception_thrown_if_username_is_null() {
        FtpConnectorInfoEntity ftpConnectorInfo = new FtpConnectorInfoEntity();
        ftpConnectorInfo.setHost("localhost");
        ftpConnectorInfo.setPort(21);
        ftpConnectorInfo.setUsername(null);
        ftpConnectorInfo.setPassword("password");
        ftpConnectorInfo.setRemoteDirectory("remote");

        assertThrows(PersistenceException.class, () -> entityManager.persist(ftpConnectorInfo));
    }

    @Test
    void test_constraint_violation_exception_thrown_if_remote_directory_is_null() {
        FtpConnectorInfoEntity ftpConnectorInfo = new FtpConnectorInfoEntity();
        ftpConnectorInfo.setHost("localhost");
        ftpConnectorInfo.setPort(21);
        ftpConnectorInfo.setUsername("username");
        ftpConnectorInfo.setPassword("password");
        ftpConnectorInfo.setRemoteDirectory(null);

        assertThrows(PersistenceException.class, () -> entityManager.persist(ftpConnectorInfo));
    }

    @Test
    void successful_insertion_when_if_password_is_null() {
        FtpConnectorInfoEntity ftpConnectorInfo = new FtpConnectorInfoEntity();
        ftpConnectorInfo.setHost("localhost");
        ftpConnectorInfo.setPort(21);
        ftpConnectorInfo.setUsername("username");
        ftpConnectorInfo.setPassword(null);
        ftpConnectorInfo.setRemoteDirectory("remote");

        assertDoesNotThrow( () -> entityManager.persist(ftpConnectorInfo));
    }

    @Test
    void test_successful_insertion_when_constraints_are_met() {
        FtpConnectorInfoEntity ftpConnectorInfo = new FtpConnectorInfoEntity();
        ftpConnectorInfo.setHost("localhost");
        ftpConnectorInfo.setPort(21);
        ftpConnectorInfo.setUsername("username");
        ftpConnectorInfo.setPassword("password");
        ftpConnectorInfo.setRemoteDirectory("remote");

        assertDoesNotThrow( () -> entityManager.persist(ftpConnectorInfo));
    }
}
