package hibernate.metamodel;

import hibernate.entity.meta.EntityClass;

import java.util.Map;

public interface MetaModel {

    Map<Class<?>, EntityClass<?>> getEntityClasses();

    <T> EntityClass<T> getEntityClass(Class<T> clazz);
}