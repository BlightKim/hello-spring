package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {
  MemoryMemberRepository repository = new MemoryMemberRepository();
  @AfterEach
  public void afterEach() {
    repository.clearStore();
  }

  @Test
  public void save() {
    Member member = new Member();
    member.setName("spring");

    repository.save(member);

    Member result = repository.findById(member.getId()).get();

    Assertions.assertThat(member).isEqualTo(result);
  }

  @Test
  public void findByName() {
    Member member1 = new Member();
    member1.setName("kim");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("lee");
    repository.save(member2);

    Member result1 = repository.findByName(member1.getName()).get();
    Member result2 = repository.findByName(member2.getName()).get();

    Assertions.assertThat(result1).isEqualTo(member1);
    Assertions.assertThat(result2).isEqualTo(member2);
  }

  @Test
  public void findAll() {
    Member member1 = new Member();
    Member member2 = new Member();

    repository.save(member1);
    repository.save(member2);

    List<Member> memberList = repository.findAll();

    Assertions.assertThat(memberList.size()).isEqualTo(2);
  }

}
