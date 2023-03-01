package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatelessServiceTest {

    @Test
    void statelessServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatelessService statelessService1 = ac.getBean(StatelessService.class);
        StatelessService statelessService2 = ac.getBean(StatelessService.class);

        //ThreadA: A 사용자 10000원 주문
        int userAPrice = statelessService1.order("userA", 10000);

        //ThreadB: B 사용자 20000원 주문
        int userBPrice = statelessService2.order("userB", 20000);

        assertEquals(userAPrice, 10000);
        assertEquals(userBPrice, 20000);
    }

    static class TestConfig {
        @Bean
        public StatelessService statelessService() {
            return new StatelessService();
        }
    }
}