package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(MemberRepository());
    }

    /**
     * 역할에 대한 구현체 리턴
     *
     * @return MemberRepository
     */
    private MemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(MemberRepository(), DiscountPolicy());
    }

    /**
     * 역할에 대한 구현체 리턴
     *
     * @return DiscountPolicy
     */
    private DiscountPolicy DiscountPolicy() {
        return new FixDiscountPolicy();
    }
}
