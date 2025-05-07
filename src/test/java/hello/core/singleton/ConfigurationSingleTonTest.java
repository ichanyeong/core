package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingleTonTest {
    @Test
    void configurationTest() {
        ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl mem = ac.getBean("memberService",MemberServiceImpl.class);
        OrderServiceImp orderService = ac.getBean(OrderServiceImp.class);

        MemberRepository memberRepository=ac.getBean(MemberRepository.class);

        MemberRepository memberRepository1=orderService.getMemberRepository();
        MemberRepository memberRepository2=mem.getMemberRepository();
        System.out.println("memberRepository1 = " + memberRepository1);
        System.out.println("memberRepository = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        Assertions.assertThat(mem.getMemberRepository()).isSameAs(memberRepository);
        Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    void ConfigurationTset() {
        ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig appConfig = ac.getBean(AppConfig.class);
        System.out.println("appConfig = " + appConfig.getClass());
    }
}
