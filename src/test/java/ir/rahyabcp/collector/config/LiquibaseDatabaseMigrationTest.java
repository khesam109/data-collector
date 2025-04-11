package ir.rahyabcp.collector.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
class LiquibaseDatabaseMigrationTest {

    @Autowired
    private DataSource dataSource;

    @Test
    void test_liquibase_data_collector_schema_created() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            ResultSet schema = connection.getMetaData().getSchemas(null, "DATA_COLLECTOR");
            assertTrue(schema.next(), "DATA_COLLECTOR schema should be created by Liquibase");
        }
    }

    @Test
    void test_liquibase_node_info_table_created() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            ResultSet nodeInfoTable = connection.getMetaData().getTables(null, "DATA_COLLECTOR", "NODE_INFO", null);
            assertTrue(nodeInfoTable.next(), "NODE_INFO table should be created by Liquibase");

            ResultSet connectionProtocolColumn = connection.getMetaData().getColumns(null, "DATA_COLLECTOR", "NODE_INFO", "CONNECTION_PROTOCOL");
            assertTrue(connectionProtocolColumn.next(), "CONNECTION_PROTOCOL column should be created by Liquibase");
            assertEquals("NO", connectionProtocolColumn.getString("IS_NULLABLE"), "CONNECTION_PROTOCOL column should be NOT NULL");

            ResultSet scheduleInfoIdColumn = connection.getMetaData().getColumns(null, "DATA_COLLECTOR", "NODE_INFO", "SCHEDULE_INFO_ID");
            assertTrue(scheduleInfoIdColumn.next(), "SCHEDULE_INFO_ID column should be created by Liquibase");
            assertEquals("NO", scheduleInfoIdColumn.getString("IS_NULLABLE"), "SCHEDULE_INFO_ID column should be NOT NULL");
        }
    }

    @Test
    void test_liquibase_schedule_info_table_created() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            ResultSet scheduleInfoTable = connection.getMetaData().getTables(null, "DATA_COLLECTOR", "SCHEDULE_INFO", null);
            assertTrue(scheduleInfoTable.next(), "SCHEDULE_INFO table should be created by Liquibase");

            ResultSet poolingIntervalColumn = connection.getMetaData().getColumns(null, "DATA_COLLECTOR", "SCHEDULE_INFO", "POOLING_INTERVAL");
            assertTrue(poolingIntervalColumn.next(), "POOLING_INTERVAL column should be created by Liquibase");
            assertEquals("NO", poolingIntervalColumn.getString("IS_NULLABLE"), "POOLING_INTERVAL column should be NOT NULL");

            ResultSet timeUnitColumn = connection.getMetaData().getColumns(null, "DATA_COLLECTOR", "SCHEDULE_INFO", "TIME_UNIT");
            assertTrue(timeUnitColumn.next(), "TIME_UNIT column should be created by Liquibase");
            assertEquals("NO", timeUnitColumn.getString("IS_NULLABLE"), "TIME_UNIT column should be NOT NULL");
        }
    }

    @Test
    void test_liquibase_ftp_connector_info_table_created() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            ResultSet ftpConnectorInfoTable = connection.getMetaData().getTables(null, "DATA_COLLECTOR", "FTP_CONNECTOR_INFO", null);
            assertTrue(ftpConnectorInfoTable.next(), "FTP_CONNECTOR_INFO table should be created by Liquibase");

            ResultSet hostColumn = connection.getMetaData().getColumns(null, "DATA_COLLECTOR", "FTP_CONNECTOR_INFO", "HOST");
            assertTrue(hostColumn.next(), "HOST column should be created by Liquibase");
            assertEquals("NO", hostColumn.getString("IS_NULLABLE"), "HOST column should be NOT NULL");

            ResultSet portColumn = connection.getMetaData().getColumns(null, "DATA_COLLECTOR", "FTP_CONNECTOR_INFO", "PORT");
            assertTrue(portColumn.next(), "PORT column should be created by Liquibase");
            assertEquals("NO", portColumn.getString("IS_NULLABLE"), "PORT column should be NOT NULL");

            ResultSet usernameColumn = connection.getMetaData().getColumns(null, "DATA_COLLECTOR", "FTP_CONNECTOR_INFO", "USERNAME");
            assertTrue(usernameColumn.next(), "USERNAME column should be created by Liquibase");
            assertEquals("NO", usernameColumn.getString("IS_NULLABLE"), "USERNAME column should be NOT NULL");

            ResultSet passwordColumn = connection.getMetaData().getColumns(null, "DATA_COLLECTOR", "FTP_CONNECTOR_INFO", "PASSWORD");
            assertTrue(passwordColumn.next(), "PASSWORD column should be created by Liquibase");
            assertEquals("YES", passwordColumn.getString("IS_NULLABLE"), "PASSWORD column can be NOT NULL");

            ResultSet remoteDirectoryColumn = connection.getMetaData().getColumns(null, "DATA_COLLECTOR", "FTP_CONNECTOR_INFO", "REMOTE_DIRECTORY");
            assertTrue(remoteDirectoryColumn.next(), "REMOTE_DIRECTORY column should be created by Liquibase");
            assertEquals("NO", remoteDirectoryColumn.getString("IS_NULLABLE"), "REMOTE_DIRECTORY column should be NOT NULL");
        }
    }
}
