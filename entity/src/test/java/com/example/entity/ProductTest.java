package com.example.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;

@DataJpaTest
class ProductTest {

    // TestEntityManager 는 EntityManager 의 메소드와 테스트에 편리한 메소드를 제공한다.
    @Autowired
    private TestEntityManager testEntityManager;
//    @Autowired
//    private EntityManager entityManager;

    private Product product;

    @BeforeEach
    void setUp() {
        //given
        this.product = new Product();

        product.setName("testName");
        product.setPrice(2000L);
        product.setUpdateTime(LocalDateTime.now());

        // 엔티티를 저장하고 즉시 테이블에 추가한다.
        testEntityManager.persistAndFlush(product);
    }

    @Test
    @DisplayName("저장 후 조회 테스트1")
    public void case1() {
        // Product 엔티티 조회 쿼리를 실행하기 위해 영속화 정보를 제거한다.
        testEntityManager.clear();

        //when
        Product result = testEntityManager.find(Product.class, this.product.getId());

        //then
        Assertions.assertEquals("testName", result.getName());
        Assertions.assertEquals(2000L, result.getPrice());

        //실행결과

        /*
        Hibernate: insert into product (create_time,name,price,update_time,id) values (?,?,?,?,default)
        Hibernate: select p1_0.id,p1_0.create_time,p1_0.name,p1_0.price,p1_0.update_time from product p1_0 where p1_0.id=?

        clear 메소드를 호출하여 영속화 정보를 제거했기 때문에 insert, select 순서로 실행이 되었다.
         */
    }

    @Test
    @DisplayName("저장 후 조회 테스트2")
    public void case2() {
        //when
        Product result = testEntityManager.find(Product.class, this.product.getId());

        //then
        Assertions.assertEquals("testName", result.getName());
        Assertions.assertEquals(2000L, result.getPrice());

        //실행결과

        /*
        Hibernate: insert into product (create_time,name,price,update_time,id) values (?,?,?,?,default)

        persist() 를 통해 엔티티가 영속화 된다.
        그리고 find() 메소드를 사용하게 되면 영속화 된 엔티티가 결과값으로 리턴된다.
        그래서 select 쿼리는 실행 되지 않는다.

        */
    }

    @Test
    @DisplayName("저장 후 변경 테스트")
    public void case3() {
        //when
        Product result = testEntityManager.find(Product.class, this.product.getId());

        result.setName("changeName");
        result.setPrice(4000L);

        testEntityManager.merge(result);
        testEntityManager.flush();

        //then
        Assertions.assertEquals("changeName", result.getName());
        Assertions.assertEquals(4000L, result.getPrice());

        //실행결과

        /*
        Hibernate: insert into product (create_time,name,price,update_time,id) values (?,?,?,?,default)
        Hibernate: update product set create_time=?,name=?,price=?,update_time=? where id=?

        persist() 를 통해 엔티티가 영속화 된다.
        그리고 find() 메소드를 사용하게 되면 영속화 된 엔티티가 결과값으로 리턴된다.
        그래서 select 쿼리는 실행 되지 않는다.
        */
    }

    @Test
    @DisplayName("저장 후 삭제 테스트")
    public void case4() {
        //when
        Product result = testEntityManager.find(Product.class, this.product.getId());

        testEntityManager.remove(result);
        testEntityManager.flush();

        //then
        result = testEntityManager.find(Product.class, this.product.getId());
        Assertions.assertNull(result);

        //실행결과

        /*
        Hibernate: insert into product (create_time,name,price,update_time,id) values (?,?,?,?,default)
        Hibernate: delete from product where id=?
        Hibernate: select p1_0.id,p1_0.create_time,p1_0.name,p1_0.price,p1_0.update_time from product p1_0 where p1_0.id=?

        삭제 쿼리를 실행하고 다시 조회하여 삭제 된 것을 확인 하였다.
        */
    }
}