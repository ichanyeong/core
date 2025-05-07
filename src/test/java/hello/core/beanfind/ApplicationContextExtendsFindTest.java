package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendsFindTest {
    ApplicationContext ac=new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    void findBeanByParentTypeDuplication() {
//        DiscountPolicy bean = ac.getBean(DiscountPolicy.class);
        assertThrows(NoUniqueBeanDefinitionException.class,()-> ac.getBean(DiscountPolicy.class));
        RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
        System.out.println("bean = " + bean);
        RateDiscountPolicy bean1 = ac.getBean(RateDiscountPolicy.class);
        System.out.println("bean1 = " + bean1);
        
    }

    @Test
    void findBeanByParentTypeBeanName() {
        DiscountPolicy discountPolicy=ac.getBean("rateDiscountPolicy",DiscountPolicy.class);
        assertThat(discountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    void findBeanBySubType() {
        DiscountPolicy discountPolicy=ac.getBean(RateDiscountPolicy.class);
         assertThat(discountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    void findAllBeanParentName() {
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        assertThat(beansOfType.size()).isEqualTo(16);
        for (String key:beansOfType.keySet()){
            System.out.println("key = " + key+"value = "+beansOfType.get(key));
        }
    }

    @Configuration
    static class TestConfig{
        @Bean
        public DiscountPolicy rateDiscountPolicy(){
            return new RateDiscountPolicy();
        }
        @Bean DiscountPolicy fixDiscountPolicy(){
            return new FixDiscountPolicy();
        }
    }

}
