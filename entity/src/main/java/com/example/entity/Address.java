package com.example.entity;

import ch.qos.logback.core.joran.conditional.IfAction;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 재사용 가능한 항목들을 모아놓은 클래스 이다.
 */
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Embeddable
public class Address {

    private String street;
    private String city;
    private String state;
    private String zip;

}
