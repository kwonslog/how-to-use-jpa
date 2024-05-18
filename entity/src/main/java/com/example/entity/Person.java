package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Person 클래스를 만들면서 Address 클래스를 사용하였다.
 * 이후 Address 클래스는 다른 엔티티 안에서도 아래 처럼 사용이 가능하다.
 */

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Embedded
    private Address address;
}
