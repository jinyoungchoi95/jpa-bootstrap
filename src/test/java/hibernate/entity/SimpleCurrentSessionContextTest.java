package hibernate.entity;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SimpleCurrentSessionContextTest {

    @Test
    void 현재_보유중인_entityManager_세션이_없는_경우_예외가_발생한다() {
        SimpleCurrentSessionContext simpleCurrentSessionContext = new SimpleCurrentSessionContext();
        assertThatThrownBy(simpleCurrentSessionContext::currentSession)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("현재 스레드에 존재하는 entitymanager 세션이 없습니다.");
    }

    @Test
    void 현재_보유중인_entityManager_세션이_있는_경우_가져온다() {
        SimpleCurrentSessionContext simpleCurrentSessionContext = new SimpleCurrentSessionContext(Map.of(Thread.currentThread(), new EntityManagerImpl(null, null)));
        EntityManager actual = simpleCurrentSessionContext.currentSession();
        assertThat(actual).isNotNull();
    }
}