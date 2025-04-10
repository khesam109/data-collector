package ir.rahyabcp.collector.infrastructure;

import ir.rahyabcp.collector.exception.impl.CreateTableException;
import ir.rahyabcp.collector.exception.impl.DropTableException;
import ir.rahyabcp.collector.exception.impl.InsertRowException;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryDatabase implements Database {

    private final Map<String, Table<?>> tables;

    public InMemoryDatabase() {
        this.tables = new ConcurrentHashMap<>();
    }

    //ddl
    @Override
    public <T> void createTable(String tableName, Class<T> rowType) {
        if (tables.containsKey(tableName)) {
            throw new CreateTableException("Table already exists with name: " + tableName);
        }

        tables.put(tableName, new Table<>(tableName, rowType));
    }

    @Override
    public void dropTable(String tableName) {
        if (!tables.containsKey(tableName)) {
            throw new DropTableException("Table does not exist: " + tableName);
        }
        tables.remove(tableName);
    }

    //dml
    @Override
    public <T> int insert(String tableName, T row) {
        Table<T> table = getTypedTable(tableName);
        int id = table.nextId();

        table.insert(id, row);
        return id;
    }

    @Override
    public <T> Optional<T> select(String tableName, int id) {
        Table<T> table = getTypedTable(tableName);
        return table.select(id);
    }

    @Override
    public <T> void update(String tableName, T row) {
        Table<T> table = getTypedTable(tableName);
        table.update(row.hashCode(), row);
    }

    @Override
    public <T> void delete(String tableName, int id) {
        Table<T> table = getTypedTable(tableName);
        table.delete(id);
    }

    @SuppressWarnings("unchecked")
    private <T> Table<T> getTypedTable(String tableName) {
        Table<?> table = tables.get(tableName);
        if (table == null) {
            throw new InsertRowException("Table does not exist: " + tableName);
        }
        return (Table<T>) table;
    }
}
