package com.example.entity.relationship.manytoone;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="EntityC")
public class EntityC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameC;

    // @JoinColumn 을 사용하여 명확하게 외래키 컬럼을 정하는 것은 좋은 방법이다.
    // 기본적으로 다대일 관계에서 @JoinColumn 은 `다`쪽에 선언해야 한다.
    // @JoinColumn 을 생략할 경우 JPA는 자동으로 `다`쪽에 외래키 컬럼을 생성한다.
    // 테이블 조인을 생각해 보면 이것은 자연스러운 일이다.
    @ManyToOne
    @JoinColumn(name = "ENTITY_D_ID")
    private EntityD entityD;
}
