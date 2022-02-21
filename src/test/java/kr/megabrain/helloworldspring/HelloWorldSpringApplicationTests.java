package kr.megabrain.helloworldspring;

import kr.megabrain.helloworldspring.domain.Member;
import kr.megabrain.helloworldspring.repository.MemberRepository;
import kr.megabrain.helloworldspring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloWorldSpringApplicationTests {

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
		assertEquals(member, result);
	}

	@Test
	public void findByName() {
		//given
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);

		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		//when
		Member result = repository.findByName("spring1").get();

		// then
		assertEquals(member1, result);
	}

	@Test
	public void findAll() {
		//given
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		//when
		List<Member> result = repository.findAll();
		//then
		assertEquals(2, result.size());
	}

}
