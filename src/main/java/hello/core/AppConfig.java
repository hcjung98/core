package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDisccountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

/*애플리케이션의 실제 동작에 필요한 구현겍체를 생성*/
/*역할과 구현 클래스가 명시적으로 보이도록 리팩토링*/
public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDisccountPolicy();
    }

}
