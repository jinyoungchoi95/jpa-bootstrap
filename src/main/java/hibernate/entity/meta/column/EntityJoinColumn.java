package hibernate.entity.meta.column;

import hibernate.entity.meta.EntityClass;
import jakarta.persistence.FetchType;

public interface EntityJoinColumn {

    String getJoinColumnName();

    FetchType getFetchType();

    EntityClass<?> getEntityClass();

    void addFieldValue(Object entity, Object value);

    void assignFieldValue(Object entity, Object value);
}
