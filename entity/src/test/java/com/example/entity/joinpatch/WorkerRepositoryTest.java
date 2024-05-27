package com.example.entity.joinpatch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
class WorkerRepositoryTest {

    @Autowired
    private WorkerRepository workerRepository;

    @Test
    public void test1() {
        List<Worker> result = workerRepository.findAll();

        //Hibernate: select w1_0.id,w1_0.age,w1_0.company_id,w1_0.name from worker w1_0
    }

    @Test
    public void test2() {
        Optional<Worker> result = workerRepository.findById(1L);

        //Hibernate: select w1_0.id,w1_0.age,w1_0.company_id,w1_0.name from worker w1_0 where w1_0.id=?
    }

    @Test
    public void test3() {
        Worker worker = workerRepository.join("홍길동");

        //Hibernate: select w1_0.id,w1_0.age,c1_0.id,c1_0.address,c1_0.name,w1_0.name from worker w1_0 join company c1_0 on c1_0.id=w1_0.company_id where w1_0.name=?
    }
}