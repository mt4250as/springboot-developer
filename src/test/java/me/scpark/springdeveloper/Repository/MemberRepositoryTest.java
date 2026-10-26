package me.scpark.springdeveloper.Repository;


import me.scpark.springdeveloper.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest // Repository Test에서 필요한 Spring Bean만 활성화
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Sql("/insert-members.sql")
    @DisplayName("member 테이블의 모든 레코드 가져오기")
    @Test
    public void getAllMembers() {
        // 준비

        // 실행
        List<Member> member = memberRepository.findAll();

        // 검증
        assertThat(member.size()).isEqualTo(4);

    }
    @Sql("/insert-members.sql")
    @DisplayName("member 테이블에서 name이 B인 레코드 가져오기")
    @Test
    public void getMemberById2() {
        //준비

        //실행
        Member member = memberRepository.findByName("B").get();

        //검증
//        assertThat(member.size()).isEqualTo(1);
//        assertThat(member.get(0).getName()).isEqualTo("엄준석");
        assertThat(member.getId()).isEqualTo(2L);

    }
    @DisplayName("하나의 Member 객체를 DB에 저장하기")
    @Test
    public void saveMember() {
        // given
        Member member = new Member("A"); // new를 사용하지 않기 위해 IoC와 DI를 개념을 배운게 아닌가?
        // when
        memberRepository.save(member);
        // then
        List<Member> members = memberRepository.findAll();
        assertThat(members.get(0).getId()).isEqualTo(1L);
    }

    @DisplayName("3개의 Member객체를 Db에 저장하기")
    @Test
    public void saveMembers() {
        // given
        List<Member> members = List.of(new Member("A1"), new Member("A2"), new Member("A3"));
        // when
        memberRepository.saveAll(members);
        // then
        assertThat(memberRepository.findAll().size()).isEqualTo(3);
    }

    @Sql("/insert-members.sql")
    @DisplayName("id가 2인 레코드 삭제하기")
    @Test
    public void deleteMemberById() {
        // given memberRepostory에 레코드를 가져오기
        // @Sql("/insert-members-sql")로 레코드 가져옴
        // when members에 들어간 id 2를 삭제하기
        memberRepository.deleteById(2L);
        // then 삭제가 되었는지 확인하기
        Optional<Member> member = memberRepository.findById(2L);
        assertThat(member.isEmpty()).isTrue();
    }

    @Sql("/insert-members.sql")
    @DisplayName("모든 레코드 삭제하기")
    @Test
    public void deleteAllMembers() {
        // given
//      @Sql을 통해 레코드를 받아 온다
        // when
        memberRepository.deleteAll();
        // then
        List<Member> member = memberRepository.findAll();
        assertThat(member.isEmpty()).isTrue();
    }
    // 내부적으로 사용되는 영속성 컨텍스트의 변경감지(dirty-checking) 기능을 이용한 레코드 변경
    @Sql("/insert-members.sql")
    @DisplayName("변경감지 기능을 이용해 id가 2인 레코드의 name을 '홍길동'으로 변경하기")
    @Test
    public void updateMember() {
        // given
        Member member = memberRepository.findById(2L).get();
        // when
        member.setName("홍길동");
        // then
        member = memberRepository.findById(2L).get();
        assertThat(member.getName()).isEqualTo("홍길동");
    }

}