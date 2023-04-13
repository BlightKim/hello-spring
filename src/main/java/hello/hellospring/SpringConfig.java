package hello.hellospring;


import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
  DataSource dataSource;
  @Autowired
  public SpringConfig(DataSource dataSource) {
    this.dataSource = dataSource;
  }
  @Bean
  public MemberService memberService() {

    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {

//    return new MemoryMemberRepository();
    return new JdbcTemplateMemberRepository(dataSource);
  }
}
