package hello.core.autowired.allbean;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AllbeanTest {
    @Test
    void findAllBean(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class,DiscountService.class);
        Member member=new Member(1L,"이찬영", Grade.VIP);
        DiscountService discountService=ac.getBean(DiscountService.class);
        int discount=discountService.discount(member,10000,"rateDiscountPolicy");
        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discount).isEqualTo(1000);
        int fixDiscountPolicy = discountService.discount(member, 111100, "fixDiscountPolicy");
        assertThat(fixDiscountPolicy).isEqualTo(1000);
    }
    static class DiscountService{
        private final Map<String, DiscountPolicy>policyMap;
        private final List<DiscountPolicy> policies;
        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int discount(Member member, int i, String rateDiscountPolicy) {
            DiscountPolicy discountPolicy = policyMap.get(rateDiscountPolicy);

            return discountPolicy.discount(member,i);
        }
    }
}