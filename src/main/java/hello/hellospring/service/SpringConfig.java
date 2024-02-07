package hello.hellospring.service;
import hello.hellospring.repository.*;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
//  private final DataSource dataSource;
//  public SpringConfig(DataSource dataSource) {
//    this.dataSource = dataSource;
//  }

  private final EntityManager em;

  @Autowired
  public SpringConfig(EntityManager em) {
    this.em = em;
  }


  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }
  @Bean
  public MemberRepository memberRepository() {
// return new MemoryMemberRepository();
// return new JdbcMemberRepository(dataSource);
// return new JdbcTemplateMemberRepository(dataSource);
    return new JpaMemberRepository(em);
  }
}
