package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy{
    private int discountFixAmount=1000;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){//enum은 ==써야한다.
            return discountFixAmount;
        }else {
            return 0;
        }
    }
}
