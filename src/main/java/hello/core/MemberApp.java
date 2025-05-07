package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig=new AppConfig();
//        MemberService memberService=appConfig.memberService();

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService=applicationContext.getBean("memberService",MemberService.class);

        Member member1=new Member(1L,"chanyoung", Grade.BASIC);
        memberService.join(member1);
        Member foundMember = memberService.findMember(1L);
        System.out.println("foundMember = " + foundMember);
        String []apps=applicationContext.getBeanDefinitionNames();
        for (String a:apps){
            System.out.println("a = " + a);
        }
    }

}
