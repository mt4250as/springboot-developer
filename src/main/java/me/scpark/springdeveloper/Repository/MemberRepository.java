package me.scpark.springdeveloper.Repository;

import me.scpark.springdeveloper.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

}
