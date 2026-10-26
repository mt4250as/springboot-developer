package me.scpark.springdeveloper.Repository;

import me.scpark.springdeveloper.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
//    public List<Member> findByName(String name);
    public Optional<Member> findByName(String name);

}
