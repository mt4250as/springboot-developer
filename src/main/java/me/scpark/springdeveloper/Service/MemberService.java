package me.scpark.springdeveloper.Service;

import me.scpark.springdeveloper.Member;
import me.scpark.springdeveloper.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    } // select * from member

    // 맴버 저장
    public Member saveMemver (Member member) {
        memberRepository.save(member); // insert into nenber value(....)
        return memberRepository.save(member);
    }
}
