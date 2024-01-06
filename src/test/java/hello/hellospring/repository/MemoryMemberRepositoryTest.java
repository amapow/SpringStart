package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository memberRepository = new MemoryMemberRepository();


//    @BeforeEach
//    void prepare() {
//        Member member1 = new Member("member1");
//        Member member2 = new Member("member2");
//        memberRepository.save(member1);
//        memberRepository.save(member2);
//    }

//    @Test
//    void save() {
//        Member result = memberRepository.findById(member1.getId()).get();
//        assertThat(result).isEqualTo(member1);
//    }

    @AfterEach
    void clearStore() {
        memberRepository.clearStore();
    }

    @Test
    void findById() {
        Member member1 = new Member("member1");
        memberRepository.save(member1);
        assertThat(member1).isEqualTo(memberRepository.findById(member1.getId()).get());
    }

    @Test
    void findByName() {
        Member member1 = new Member("member1");
        memberRepository.save(member1);
        assertThat(member1).isEqualTo(memberRepository.findByName("member1").get());
    }

    @Test
    void findAll() {
        Member member1 = new Member("member1");
        memberRepository.save(member1);

        Member member2 = new Member("member1");
        memberRepository.save(member2);

        assertThat(memberRepository.findAll().size()).isEqualTo(2);
    }
}