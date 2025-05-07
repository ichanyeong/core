package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.text.html.Option;
import java.util.Optional;

public class AutowiredTest {
    @Test
    void AutowiredOption( ) {
        ApplicationContext ac=new AnnotationConfigApplicationContext(TestBean.class);
    }
    static class TestBean{
        @Autowired(required = false)
        public void setBean1(Member bean1){//member는 스프링 컨테이너가 관리하고 있는 빈이 아니다.
            System.out.println("bean1 = " + bean1);
        }
        @Autowired
        public void setBean2(@Nullable Member bean2){
            System.out.println("bean2 = " + bean2);
        }
        @Autowired
        public void setBean3(Optional<Member> bean3){
            System.out.println("bean3 = " + bean3);
        }


    }
}
