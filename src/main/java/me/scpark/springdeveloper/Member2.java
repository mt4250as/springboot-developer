package me.scpark.springdeveloper;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor

public class Member2 {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String email;

    public Member2(String name,String email){
        this.name = name;
        this.email = email;
    }


}
