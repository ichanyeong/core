package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicSameFind {
    AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(SameBeanCofig.class);

    @Test
    void findBeanByTypeDu() {
        assertThrows(NoUniqueBeanDefinitionException.class,()->{
            MemberRepository memberRepository = ac.getBean(MemberRepository.class);
        });
    }

    @Test
    void findByAllBeanType() {
        Map<String, MemberRepository> memberRepositoryMap = ac.getBeansOfType(MemberRepository.class);
        for (String key:memberRepositoryMap.keySet()){
            System.out.println("key = " + key);
        }
        for (MemberRepository memberRepository1:memberRepositoryMap.values()){
            System.out.println("memberRepository1 = " + memberRepository1);
        }
        System.out.println("memberRepositoryMap = " + memberRepositoryMap);
        ApplicationContext kc=new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl bean = kc.getBean(MemberServiceImpl.class);
        System.out.println("bean = " + bean);
    }

    MemberRepository memberRepository = ac.getBean("memberRepository1",MemberRepository.class);
    @Configuration
    static class SameBeanCofig{
        @Bean
        public MemberRepository memberRepository1(){
            return new MemoryMemberRepository();
        }
        @Bean
        public MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }


    }
}
