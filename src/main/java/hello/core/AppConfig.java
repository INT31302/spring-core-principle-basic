package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Application 구성 정보 담당 하는 Configuration Class
 */
@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(MemberRepository());
    }

    /**
     * 역할에 대한 구현체 리턴
     *
     * @return MemberRepository
     */
    @Bean
    public MemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(MemberRepository(), DiscountPolicy());
    }

    /**
     * 역할에 대한 구현체 리턴
     *
     * @return DiscountPolicy
     */
    @Bean
    public DiscountPolicy DiscountPolicy() {
//        구현체 변경
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
