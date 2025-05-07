package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class SingleTonTest {
    @Test
    void singleTonBeanTst() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingleTonBean.class);
        SingleTonBean bean1 = ac.getBean(SingleTonBean.class);
        SingleTonBean bean2 = ac.getBean(SingleTonBean.class);
        Assertions.assertThat(bean1).isSameAs(bean2);
        ac.close();

    }
    @Component
    @Scope("singleton")
    static class SingleTonBean{
        @PostConstruct
    public void init(){
        System.out.println("SingleTon.init");
    }
    @PreDestroy
        public void destroy(){
        System.out.println("SingleTon.destroy");
    }
    }
}
