package com.example.relationship.onetoone;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="EntityA")
public class EntityA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameA;

    // @JoinColumn 을 사용하면 EntityA 테이블에 ENTITY_B_ID 라는 외래키 컬럼이 생성된다.
    // 일대일 관계에서는 @JoinColumn 을 사용하여 외래키 컬럼이 생성되는 테이블을 지정해야 한다.
    @OneToOne
    @JoinColumn(name = "ENTITY_B_ID")
    private EntityB entityB;
}
