package com.example.entity.joinpatch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

    /*
       FETCH JOIN 을 사용하기 위해서는 두 엔티티간에 연관관계가 필수적으로 필요하다.
       단방향 또는 양방향으로 연관관계가 매핑이 필요한 것이다.
       만약 연관관계가 매핑 되지 않은 경우에는 FETCH JOIN을 사용 할 수 없다.
     */
    @Query("SELECT w FROM Worker w JOIN FETCH w.company WHERE w.name = :name")
    Worker join(@Param("name") String name);
}
