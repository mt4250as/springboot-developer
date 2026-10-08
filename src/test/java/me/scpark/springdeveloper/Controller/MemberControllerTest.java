package me.scpark.springdeveloper.Controller;

import me.scpark.springdeveloper.Member;
import me.scpark.springdeveloper.Repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest             //Spring Bean 만듬
@AutoConfigureMockMvc       //가상의 인터넷을 만들어 테스트하기 위해 만듬
class MemberControllerTest {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void deleteAll() {
        memberRepository.deleteAll();
    }

    @Test
    void getAllmembers() throws Exception {
        // 준비 (given)
        // 한 명의 회원을 DB 테이블에 저장함으로써 등록
        final String url = "/member";
        Member savedMamber = memberRepository.save(new Member("엄준석")); // insert into ... , update
        // 실행 (when)
        // 회원 리스트 요청
        final ResultActions result =  mockMvc.perform(get(url).accept(MediaType.APPLICATION_JSON));
        // 검증 (then)
        // 회원 리스트 요청에 의해서 전달 받은 데이터가 준비 단계에서 저장된 회원 정보와 동일핝지 검증
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(savedMamber.getId()))
                .andExpect(jsonPath("$[0].name").value(savedMamber.getName()));
    }
}