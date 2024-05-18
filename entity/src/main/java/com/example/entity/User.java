package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Users")
// 현재는 하나의 추가 테이블을 사용하였지만 2개 이상 가능하다.
@SecondaryTable(name = "UserDetail", pkJoinColumns = @PrimaryKeyJoinColumn(name = "USER_ID"))
public class User extends DateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    // email, phoneNumber 는 UserDetail 테이블에 저장 된다.
    @Column(table = "UserDetail")
    private String email;

    @Column(table = "UserDetail")
    private String phoneNumber;
}
