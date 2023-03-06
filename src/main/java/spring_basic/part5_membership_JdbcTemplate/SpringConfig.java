package spring_basic.part5_membership_JdbcTemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_basic.part5_membership_JdbcTemplate.repository.JdbcTemplateMemberRepository;
import spring_basic.part5_membership_JdbcTemplate.repository.MemberRepository;
import spring_basic.part5_membership_JdbcTemplate.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    //변수
    private final DataSource dataSource;

    //생성자
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //메서드
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JdbcTemplateMemberRepository(dataSource);
    }
}

