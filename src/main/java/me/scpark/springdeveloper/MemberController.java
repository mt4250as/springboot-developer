package me.scpark.springdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;
    //요청읗 받아서 적절한 비즈니스로직으로 연결
    // http://localhost:8080/member 요청과 매서드를 연결
    @GetMapping("/member")
    public List<Member> getAllMember() {
        return memberService.getAllMembers();
    }
}


//@Autowired
//MumberService testService;
//@GetMapping("/member")
//public List<Member> getAllMembers() {
//    List<Member> member = testService.getAllMembers();
//    return member;
//}
