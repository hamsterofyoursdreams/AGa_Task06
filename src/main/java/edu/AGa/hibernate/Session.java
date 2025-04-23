package edu.AGa.hibernate;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Session {
    public String getSql(Class<?> entityClass) {
        validateAnnotations(entityClass);

        String tableName = resolveTableName(entityClass);
        List<String> columns = resolveColumns(entityClass);

        return buildSelectQuery(tableName, columns);
    }

    private void validateAnnotations(Class<?> entityClass) {
        if (!entityClass.isAnnotationPresent(Table.class)) {
            throw new IllegalArgumentException("Class must be annotated with @Table");
        }
    }

    private String resolveTableName(Class<?> entityClass) {
        Table tableAnnotation = entityClass.getAnnotation(Table.class);
        return tableAnnotation.name().isEmpty() ?
                entityClass.getSimpleName() :
                tableAnnotation.name();
    }

    private List<String> resolveColumns(Class<?> entityClass) {
        List<String> columns = new ArrayList<>();
        for (Field field : entityClass.getDeclaredFields()) {
            String columnName = field.getName();

            if (field.isAnnotationPresent(Column.class)) {
                Column columnAnnotation = field.getAnnotation(Column.class);
                if (!columnAnnotation.name().isEmpty()) {
                    columnName = columnAnnotation.name();
                }
            }

            columns.add(columnName);
        }
        return columns;
    }

    private String buildSelectQuery(String tableName, List<String> columns) {
        return String.format("SELECT %s FROM %s",
                String.join(", ", columns),
                tableName);
    }
}
