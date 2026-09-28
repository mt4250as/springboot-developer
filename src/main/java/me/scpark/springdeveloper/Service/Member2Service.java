package me.scpark.springdeveloper.Service;

import lombok.RequiredArgsConstructor;
import me.scpark.springdeveloper.Member2;
import me.scpark.springdeveloper.Repository.Member2Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Member2Service {
    private final Member2Repository member2Repository;

    // 회원 저장
    public Member2 saveMember2(Member2 member2) {
        return member2Repository.save(member2);
    }

    // 회원 전체 조회
    public List<Member2> findAllMembers() {
        return member2Repository.findAll();
    }
}