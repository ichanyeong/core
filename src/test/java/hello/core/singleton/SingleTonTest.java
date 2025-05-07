package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingleTonTest {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        MemberService memberService1 = appConfig.memberService();
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService = " + memberService);
        assertThat(memberService1).isNotSameAs(memberService);
        MemberService bean1 = ac.getBean(MemberService.class);
        MemberService bean2 = ac.getBean(MemberService.class);
        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);
        AppConfig appConfig1 = ac.getBean(AppConfig.class);
        System.out.println("appConfig1 = " + appConfig1);
    }

    @Test
    void SingleTonServiceTest() {
        SingleTonService inntacne = SingleTonService.getInntacne();
        SingleTonService inntacne1 = SingleTonService.getInntacne();
        System.out.println("inntacne1 = " + inntacne1);
        System.out.println("inntacne = " + inntacne);
        inntacne.logic();
        assertThat(inntacne).isSameAs(inntacne1);
    }
}