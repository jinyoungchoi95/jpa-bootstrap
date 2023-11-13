package hibernate.entity.meta.column;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.lang.reflect.Field;
import java.util.Objects;

public class EntityId implements EntityColumn {

    private final GenerationType generationType;
    private final EntityField entityField;

    public EntityId(final Field field) {
        if (!field.isAnnotationPresent(Id.class)) {
            throw new IllegalArgumentException("Id 어노테이션이 없습니다.");
        }
        this.generationType = parseGenerationType(field);
        this.entityField = new EntityField(field);
    }

    private static GenerationType parseGenerationType(final Field field) {
        if (!field.isAnnotationPresent(GeneratedValue.class)) {
            return GenerationType.AUTO;
        }
        return field.getAnnotation(GeneratedValue.class).strategy();
    }

    @Override
    public String getFieldName() {
        return entityField.getFieldName();
    }

    @Override
    public Object getFieldValue(final Object entity) {
        return entityField.getFieldValue(entity);
    }

    @Override
    public void assignFieldValue(final Object instance, final Object value) {
        entityField.assignFieldValue(instance, value);
    }

    @Override
    public ColumnType getColumnType() {
        return entityField.getColumnType();
    }

    @Override
    public boolean isNullable() {
        return entityField.isNullable();
    }

    @Override
    public boolean isId() {
        return true;
    }

    @Override
    public GenerationType getGenerationType() {
        return generationType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityId entityId = (EntityId) o;
        return Objects.equals(entityField, entityId.entityField);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entityField);
    }
}
