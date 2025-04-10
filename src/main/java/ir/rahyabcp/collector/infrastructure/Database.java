package ir.rahyabcp.collector.infrastructure;

import java.util.Optional;

public interface Database {

    <T> void createTable(String tableName, Class<T> rowType);
    void dropTable(String tableName);
    <T> int insert(String tableName, T row);
    <T> Optional<T> select(String tableName, int id);
    <T> void update(String tableName, T row);
    <T> void delete(String tableName, int id);
}
