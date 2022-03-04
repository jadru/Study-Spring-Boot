package kr.megabrain.helloworldspring;

import kr.megabrain.helloworldspring.aop.TimeTraceAop;
import kr.megabrain.helloworldspring.repository.JpaMemberRepository;
import kr.megabrain.helloworldspring.repository.MemberRepository;
import kr.megabrain.helloworldspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    @Bean public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }
}
