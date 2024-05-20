package com.example.relationship.manytomany;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="EntityE")
public class EntityE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameE;

    // @JoinTable 은 생략이 가능하며 생략할 경우 JPA가 자동으로 생성한다.
    // @JoinTable name 은 중간 테이블명이다.
    // joinColumns, inverseJoinColumns 은 중간 테이블의 기본키가 된다.
    // 그리고 각각 E, F 엔티티의 기본키에 대한 외래키가 된다.
    //    PRIMARY KEY (ENTITY_E_ID, ENTITY_F_ID),
    //    FOREIGN KEY (ENTITY_E_ID) REFERENCES EntityE(id),
    //    FOREIGN KEY (ENTITY_F_ID) REFERENCES EntityF(id)
    @ManyToMany
    @JoinTable(name = "ENTITY_EF",
            joinColumns = @JoinColumn(name = "ENTITY_E_ID"),
            inverseJoinColumns = @JoinColumn(name="ENTITY_F_ID"))
    private List<EntityF> entityF;
}
