package hibernate.event.persist;

import hibernate.metamodel.BasicMetaModel;
import hibernate.metamodel.MetaModel;
import hibernate.metamodel.MetaModelImpl;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PersistEventTest {

    private final MetaModel metaModel = MetaModelImpl.createPackageMetaModel(BasicMetaModel.createPackageMetaModel("hibernate.event.persist"), null);

    @Test
    void PersistEvent를_생성한다() {
        TestEntity givenEntity = new TestEntity();
        PersistEvent<TestEntity> actual = PersistEvent.createEvent(metaModel, givenEntity);
        assertAll(
                () -> assertThat(actual.getEntity()).isEqualTo(givenEntity),
                () -> assertThat(actual.getClazz()).isEqualTo(TestEntity.class)
        );
    }

    @Entity
    private static class TestEntity {
        @Id
        private Long id;
    }
}
