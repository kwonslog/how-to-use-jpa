package com.example.entity.repository;

import com.example.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query(value = "select p from Payment p where p.id = :id")
    Optional<Payment> getId(@Param("id") long id);
}
