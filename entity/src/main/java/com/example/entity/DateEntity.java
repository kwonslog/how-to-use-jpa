package com.example.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 공통으로 사용하는 항목들을 모아서 클래스를 만들었다.
 * @MappedSuperclass 어노테이션을 지정하여 이 클래스를 상속받아 사용 할 수 있도록 했다.
 */
@Getter @Setter
@MappedSuperclass
public class DateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
