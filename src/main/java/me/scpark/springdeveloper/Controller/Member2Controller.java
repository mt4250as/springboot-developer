package me.scpark.springdeveloper.Controller;

import lombok.RequiredArgsConstructor;
import me.scpark.springdeveloper.Member;
import me.scpark.springdeveloper.Member2;
import me.scpark.springdeveloper.Service.Member2Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class Member2Controller {

    private final Member2Service member2Service;

    @PostMapping
    public ResponseEntity<Member2> createMember(@RequestBody Member2 member2) {
        return ResponseEntity.ok(member2Service.saveMember2(member2));

    }
    @GetMapping
    public ResponseEntity<List<Member2>> getAllMember2() {
        return ResponseEntity.ok(member2Service.findAllMembers());
    }
}
