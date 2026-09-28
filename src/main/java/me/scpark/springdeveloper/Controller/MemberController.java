package me.scpark.springdeveloper.Controller;

import lombok.RequiredArgsConstructor;
import me.scpark.springdeveloper.Member;
import me.scpark.springdeveloper.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class MemberController {
    @Autowired
    private MemberService memberService;
    //요청읗 받아서 적절한 비즈니스로직으로 연결
    // http://localhost:8080/member 요청과 매서드를 연결
    @GetMapping("/member")
    public List<Member> getAllMember() {
        return memberService.getAllMembers();
    }

    // 회원 정보를 등록하는 요청을 처리
    // 로걸 호스트 member 요청을 post 방직으로 했을 때 회원 등록을 처리하도록 구현
    @PostMapping("/member")
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        // 비즈니스 로직을 호출 (Service에 구현)
//        return ResponseEntity.ok(memberService.(member));
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.saveMemver(member));
    }

}

//localhost:8080/member?id=1&name=홍길동 <- @REquestParam
//localhost:8080/member/1/홍길동 <- @PathVariable

//HTTP Request : 1) HTTP Header, 2) HTTP Body

//@RequestBody


















