package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {
    @Test
    void basicScan() {
        ApplicationContext ac=new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberServiceImpl memberService = ac.getBean(MemberServiceImpl.class);
        System.out.println("memberService = " + memberService.getClass());
        MemberRepository memberRepository=ac.getBean(MemberRepository.class);
        System.out.println("memberRepository = " + memberRepository);
        MemberRepository memberRepository1 = memberService.getMemberRepository();
        System.out.println("memberRepository1 = " + memberRepository1);
        Assertions.assertThat(memberRepository1).isSameAs(memberRepository);

    }

    @Test
    void basicScan1() {
        ApplicationContext ac=new AnnotationConfigApplicationContext(AutoAppConfig.class);
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName:beanDefinitionNames){
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
        AutoAppConfig autoAppConfig = ac.getBean( AutoAppConfig.class);
        System.out.println("autoAppConfig = " + autoAppConfig);
    }
}
