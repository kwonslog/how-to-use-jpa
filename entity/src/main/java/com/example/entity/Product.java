package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * DateEntity는 @MappedSuperclass 를 사용하여 작성 되었다.
 * 그래서 DateEntity 를 상속받아 id, createTime, updateTime 을 사용 할 수 있다.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name = "Product")
public class Product extends DateEntity {

    // 필수값인 @Id 항목이 있어야 한다.
    // DateEntity 를 상속 받아서 @Id 값을 해결하고 있다.

    private String name;
    private BigDecimal price;
}
