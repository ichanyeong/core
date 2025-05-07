package hello.core.scope;

import ch.qos.logback.core.net.server.Client;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class PrototypeBeanTest {
    @Test
    void prototypeBeanTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("find bean1");
        PrototypeBean bean1 = ac.getBean(PrototypeBean.class);
        System.out.println("bean1 = " + bean1);
        System.out.println("find bean2");
        PrototypeBean bean2 = ac.getBean(PrototypeBean.class);
        System.out.println("bean2 = " + bean2);
        Assertions.assertThat(bean1).isNotSameAs(bean2);
        bean1.destroy();
    }

    @Test
    void prototypeBeanTest2() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean bean = ac.getBean(PrototypeBean.class);
        PrototypeBean bean1 = ac.getBean(PrototypeBean.class);

        int count=bean.Plus();
        int count1=bean1.Plus();

        Assertions.assertThat(count).isEqualTo(count1);
    }

    @Test
    void clientGetPrototypeBeanTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(CilentBean.class, PrototypeBean.class);
        CilentBean client = ac.getBean(CilentBean.class);
        CilentBean clinet1=ac.getBean(CilentBean.class);

        int count0 = client.logic();
        int count1=client.logic();
        Assertions.assertThat(count1-1).isEqualTo(count0);
    }
    @Component
//    @ComponentScan(basePackages ="hello.core.scope")
    static class CilentBean{
        private final PrototypeBean prototypeBean;
        @Autowired
        public CilentBean(PrototypeBean prototypeBean) {
            this.prototypeBean = prototypeBean;
        }
        public int logic(){
            return prototypeBean.Plus();
        }
    }

    @Scope("prototype")
    @Component
    static class PrototypeBean{
        private int count=0;
        @PostConstruct
        public void init(){
            System.out.println("Prototype.Init");
        }
        @PreDestroy
        public void destroy(){
            System.out.println("Prototype.destroy");
        }
        public int Plus(){
            count++;
            return count;
        }
    }
}
