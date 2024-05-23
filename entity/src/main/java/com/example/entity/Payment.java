package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 엔티티를 작성할떄 기본적으로 있어야 하는 항목들에 대한 샘플 코드이다.
 */
@Entity
@Table(name = "payment")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "AMOUNT")
    private long amount;

    @Column(name = "DATE")
    private LocalDateTime date;

    @Column(name = "METHOD")
    private String method;
}
