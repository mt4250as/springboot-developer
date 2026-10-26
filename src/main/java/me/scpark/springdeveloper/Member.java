package me.scpark.springdeveloper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id", updatable = false)
    private Long id;
    @Setter(AccessLevel.PUBLIC)
    @Column(name="name", nullable = false)
    private String name;
    public Member (String nane) {
        this.name = nane;
    }

}
