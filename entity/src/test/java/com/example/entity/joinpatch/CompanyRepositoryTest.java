package com.example.entity.joinpatch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void test3() {
        Company company = companyRepository.join("홍길동");

        //Hibernate: select c1_0.id,c1_0.address,c1_0.name,w1_0.company_id,w1_0.id,w1_0.age,w1_0.name from company c1_0 join worker w1_0 on c1_0.id=w1_0.company_id where c1_0.name=?
    }
}