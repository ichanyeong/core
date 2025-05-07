package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.*;
class  StatefulServiceTest {
    @Test
    public void stateSingleTonService() {
        ApplicationContext ac=new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService bean = ac.getBean("statefulService",StatefulService.class);
        bean.order("memberA",100);
        bean.order("memberB",1000);
        System.out.println("bean.getPrice() = " + bean.getPrice());
    }
    @Configuration
      static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}

