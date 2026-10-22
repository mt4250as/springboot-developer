package me.scpark.springdeveloper.Repository;

import me.scpark.springdeveloper.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    public List<Member> findByName(String name);

}
