package me.scpark.springdeveloper.Repository;


import me.scpark.springdeveloper.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

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
        assertThat(member.size()).isEqualTo(3);

    }
    @Sql("/insrt-member.sql")
    @DisplayName("member 테이블에서 id가 2인 레코드 가져오기")
    @Test
    public void getMemberById2() {
        //준비

        //실행
       Optional<Member> member = memberRepository.findById(2L);
       if (member.isPresent()){
           Member result = member.get();
       }
        //검증
        assertThat(member.getName()).isEqualtTo("B");
    }

}