package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.singleton.SingleTonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    private  MemberService memberService;
    private OrderService orderService;
    @BeforeEach
    public void beforEach(){
        AppConfig appConfig=new AppConfig();
     memberService=appConfig.memberService();
     orderService= appConfig.orderService();

    }
    @Test
    public  void createOrder() {


    Long memberId=1L;
    Member member=new Member(memberId,"memberA", Grade.VIP);
    memberService.join(member);
    Order order=orderService.createOrder(memberId,"ItemA",10000);
        Assertions.assertEquals(order.getDiscountPrice(),1000);
    }

    public static void main(String[] args) {
        SingleTonService singleTonService=SingleTonService.getInntacne();
        System.out.println("singleTonService = " + singleTonService);
    }
}
