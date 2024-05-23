package com.example.entity;

import com.example.entity.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class PaymentRepositoryTest {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Payment payment;

    @BeforeEach
    public void setUp() {
        this.payment = paymentRepository.save(Payment.builder()
                .amount(20000L)
                .date(LocalDateTime.now())
                .method("card")
                .build());

        // findById 메소드 호출시 select 쿼리가 발생하도록 하기 위해 영속화 정보를 삭제 한다.
        entityManager.clear();
    }

    @Test
    @DisplayName("findById 로 조회 하기")
    public void test() {
        Payment result = paymentRepository.findById(this.payment.getId()).orElse(null);

        assertNotNull(result);
    }

    @Test
    @DisplayName("@Query 로 조회 하기")
    public void test2() {
        Payment result = paymentRepository.getId(this.payment.getId()).orElse(null);

        assertNotNull(result);
    }
}