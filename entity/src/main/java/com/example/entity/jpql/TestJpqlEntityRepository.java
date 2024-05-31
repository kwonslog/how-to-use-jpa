package com.example.entity.jpql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TestJpqlEntityRepository extends JpaRepository<TestJpqlEntity, Long>, JpaSpecificationExecutor<TestJpqlEntity> {
    // JPQL 쿼리 예시
    @Query("SELECT t FROM TestJpqlEntity t WHERE t.name = ?1")
    List<TestJpqlEntity> findByName(String name);

    @Query("SELECT t FROM TestJpqlEntity t WHERE t.age = ?1")
    List<TestJpqlEntity> findByAge(int age);

    @Query("SELECT t FROM TestJpqlEntity t WHERE t.name = ?1 ORDER BY t.age ASC")
    List<TestJpqlEntity> findByNameOrderByAge(String name);

    @Query("SELECT t.address, COUNT(t) FROM TestJpqlEntity t GROUP BY t.address")
    List<Object[]> countByAddressGroupByAddress();
}
