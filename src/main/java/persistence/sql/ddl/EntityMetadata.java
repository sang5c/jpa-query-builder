package persistence.sql.ddl;

import java.util.List;

public class EntityMetadata {

    private final TableMetadata tableMetadata;
    private final ColumnMetadata columnMetadata;

    private EntityMetadata(TableMetadata tableMetadata, ColumnMetadata columnMetadata) {
        this.tableMetadata = tableMetadata;
        this.columnMetadata = columnMetadata;
    }

    public static EntityMetadata from(Class<?> clazz) {
        TableMetadata tableMetadata = TableMetadata.from(clazz);
        ColumnMetadata columnMetadata = ColumnMetadata.from(clazz);
        return new EntityMetadata(tableMetadata, columnMetadata);
    }

    public String getTableName() {
        return tableMetadata.getName();
    }

    public ColumnMetadata getColumnMetadata() {
        return columnMetadata;
    }

    public List<Column> getPrimaryKeys() {
        return columnMetadata.getPrimaryKeys();
    }
}