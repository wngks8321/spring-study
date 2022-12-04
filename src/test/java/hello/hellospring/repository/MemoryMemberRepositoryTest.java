package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 테스트 하나가 끝나고 호출되는 메소드임
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        // optional 일때는 .get() 으로 바로 꺼낼 수 있음. (바로 get으로 꺼내는게 좋은 방법은 아닌데 테스트 코드에서는 사용하는 경우가 있음.)
        Member result = repository.findById(member.getId()).get();
        // System.out.println("result = " + (result == member));
        /*
        * Assertions에 같은 값인지 확인하는 것이 있음.
        * 성공하면 아무값도 뜨지않고, 실패하면 오류가 남.
        * */
        // Assertions.assertEquals(member, result);
        /*
        * assertj에 있는 기능임.
        * 위의 Assertions.assertEquals은 매개변수를 반대로 넣을 수도 있는데, 아래 assertThat은 영어문법대로 읽히는 느낌이라 좀 더 편한느낌.
        * static import 하면 앞의 Assertions는 제외할 수 있음.
        * */
        assertThat(member).isEqualTo(result);
    }
    
    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }
    
    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        // result List의 size가 2이길 기대
        assertThat(result.size()).isEqualTo(2);
    }
}
