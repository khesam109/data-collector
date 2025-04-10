package ir.rahyabcp.collector.infrastructure;

import ir.rahyabcp.collector.exception.impl.DeleteRowException;
import ir.rahyabcp.collector.exception.impl.InsertRowException;
import ir.rahyabcp.collector.exception.impl.UpdateRowException;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class Table<T> {

    private final String name;
    private final Class<T> rowType;
    private final Map<Integer, T> rows;
    private final AtomicInteger idGenerator;

    public Table(String name, Class<T> rowType) {
        this.name = name;
        this.rowType = rowType;
        this.rows = new ConcurrentHashMap<>();
        this.idGenerator = new AtomicInteger(1000);
    }

    int nextId() {
        return idGenerator.getAndIncrement();
    }

    public void insert(int id, T row) {
        if (row == null) {
            throw new InsertRowException("row can not be null");
        }
        if (!rowType.isAssignableFrom(row.getClass())) {
            throw new InsertRowException("row type is not compatible with " + rowType.getName());
        }
        rows.put(id, row);
    }

    public Optional<T> select(int id) {
        return Optional.ofNullable(
                rows.get(id)
        );
    }

    public void update(int id, T row) {
        if (!rows.containsKey(id)) {
            throw new UpdateRowException("Row not found with id: " + id);
        }
        if (row == null) {
            throw new UpdateRowException("Row cannot be null");
        }
        if (!rowType.isInstance(row)) {
            throw new UpdateRowException("Invalid row type");
        }
        rows.put(id, row);
    }

    public void delete(int id) {
        if (!rows.containsKey(id)) {
            throw new DeleteRowException("Row not found with id: " + id);
        }
        rows.remove(id);
    }
}
