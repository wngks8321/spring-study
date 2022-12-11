package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // name 같은 값은 프로젝트마다 다르기 때문에 공통으로 제공해주지 않지만 아래와 같이 작성해서 사용할 수 있다.
    // JPQL select m from Member m where m.name = ? << 요렇게 작성해주고 SQL로 변환됨.
    @Override
    Optional<Member> findByName(String name);
}