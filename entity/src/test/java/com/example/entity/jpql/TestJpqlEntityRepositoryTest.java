package com.example.entity.jpql;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class TestJpqlEntityRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TestJpqlEntityRepository repository;

    @Test
    @DisplayName("이름으로 검색하면 올바른 엔티티를 반환합니다")
    void findByNameReturnsCorrectEntities() {
        TestJpqlEntity entity1 = new TestJpqlEntity();
        entity1.setName("Test Name");
        entityManager.persistAndFlush(entity1);

        TestJpqlEntity entity2 = new TestJpqlEntity();
        entity2.setName("Test Name");
        entityManager.persistAndFlush(entity2);

        List<TestJpqlEntity> entities = repository.findByName("Test Name");

        assertEquals(2, entities.size());
        assertTrue(entities.contains(entity1));
        assertTrue(entities.contains(entity2));
    }

    @Test
    @DisplayName("존재하지 않는 이름으로 검색하면 빈 목록을 반환합니다")
    void findByNameReturnsEmptyListForNonExistingName() {
        assertTrue(repository.findByName("Non-existing").isEmpty());
    }

    @Test
    @DisplayName("나이로 검색하면 올바른 엔티티를 반환합니다")
    void findByAgeReturnsCorrectEntities() {
        TestJpqlEntity entity1 = new TestJpqlEntity();
        entity1.setAge(30);
        entityManager.persistAndFlush(entity1);

        TestJpqlEntity entity2 = new TestJpqlEntity();
        entity2.setAge(30);
        entityManager.persistAndFlush(entity2);

        List<TestJpqlEntity> entities = repository.findByAge(30);

        assertEquals(2, entities.size());
        assertTrue(entities.contains(entity1));
        assertTrue(entities.contains(entity2));
    }

    @Test
    @DisplayName("존재하지 않는 나이로 검색하면 빈 목록을 반환합니다")
    void findByAgeReturnsEmptyListForNonExistingAge() {
        assertTrue(repository.findByAge(100).isEmpty());
    }

    @Test
    @DisplayName("이름으로 검색하면 나이 순으로 정렬된 엔티티를 반환합니다")
    void findByNameOrderByAgeReturnsEntitiesInCorrectOrder() {
        TestJpqlEntity entity1 = new TestJpqlEntity();
        entity1.setName("Test Name");
        entity1.setAge(30);
        entityManager.persistAndFlush(entity1);

        TestJpqlEntity entity2 = new TestJpqlEntity();
        entity2.setName("Test Name");
        entity2.setAge(20);
        entityManager.persistAndFlush(entity2);

        List<TestJpqlEntity> entities = repository.findByNameOrderByAge("Test Name");

        assertEquals(2, entities.size());
        assertEquals(entity2, entities.get(0));
        assertEquals(entity1, entities.get(1));
    }

    @Test
    @DisplayName("주소별로 그룹화된 엔티티 수를 반환합니다")
    void countByAddressGroupByAddressReturnsCorrectCounts() {
        TestJpqlEntity entity1 = new TestJpqlEntity();
        entity1.setAddress("Address 1");
        entityManager.persistAndFlush(entity1);

        TestJpqlEntity entity2 = new TestJpqlEntity();
        entity2.setAddress("Address 1");
        entityManager.persistAndFlush(entity2);

        TestJpqlEntity entity3 = new TestJpqlEntity();
        entity3.setAddress("Address 2");
        entityManager.persistAndFlush(entity3);

        List<Object[]> counts = repository.countByAddressGroupByAddress();

        assertEquals(2, counts.size());
        assertEquals("Address 1", counts.get(0)[0]);
        assertEquals(2L, counts.get(0)[1]);
        assertEquals("Address 2", counts.get(1)[0]);
        assertEquals(1L, counts.get(1)[1]);
    }

    @Test
    @DisplayName("이름, 나이, 주소가 모두 null이 아닌 경우 올바른 엔티티를 반환합니다")
    void returnsCorrectEntitiesWhenAllParametersAreNotNull() {
        TestJpqlEntity entity1 = new TestJpqlEntity();
        entity1.setName("Test Name");
        entity1.setAge(30);
        entity1.setAddress("Test Address");
        entityManager.persistAndFlush(entity1);

        List<TestJpqlEntity> entities = repository.findAll(
                TestJpqlEntitySpecification.hasName("Test Name")
                        .and(TestJpqlEntitySpecification.hasAge(30))
                        .and(TestJpqlEntitySpecification.hasAddress("Test Address"))
        );

        assertEquals(1, entities.size());
        assertTrue(entities.contains(entity1));
    }

    @Test
    @DisplayName("이름만 null이 아닌 경우 올바른 엔티티를 반환합니다")
    void returnsCorrectEntitiesWhenOnlyNameIsNotNull() {
        TestJpqlEntity entity1 = new TestJpqlEntity();
        entity1.setName("Test Name");
        entityManager.persistAndFlush(entity1);

        List<TestJpqlEntity> entities = repository.findAll(
                TestJpqlEntitySpecification.hasName("Test Name")
                        .and(TestJpqlEntitySpecification.hasAge(null))
                        .and(TestJpqlEntitySpecification.hasAddress(null))
        );

        assertEquals(1, entities.size());
        assertTrue(entities.contains(entity1));
    }

    @Test
    @DisplayName("나이만 null이 아닌 경우 올바른 엔티티를 반환합니다")
    void returnsCorrectEntitiesWhenOnlyAgeIsNotNull() {
        TestJpqlEntity entity1 = new TestJpqlEntity();
        entity1.setAge(30);
        entityManager.persistAndFlush(entity1);

        List<TestJpqlEntity> entities = repository.findAll(
                TestJpqlEntitySpecification.hasName(null)
                        .and(TestJpqlEntitySpecification.hasAge(30))
                        .and(TestJpqlEntitySpecification.hasAddress(null))
        );

        assertEquals(1, entities.size());
        assertTrue(entities.contains(entity1));
    }

    @Test
    @DisplayName("주소만 null이 아닌 경우 올바른 엔티티를 반환합니다")
    void returnsCorrectEntitiesWhenOnlyAddressIsNotNull() {
        TestJpqlEntity entity1 = new TestJpqlEntity();
        entity1.setAddress("Test Address");
        entityManager.persistAndFlush(entity1);

        List<TestJpqlEntity> entities = repository.findAll(
                TestJpqlEntitySpecification.hasName(null)
                        .and(TestJpqlEntitySpecification.hasAge(null))
                        .and(TestJpqlEntitySpecification.hasAddress("Test Address"))
        );

        assertEquals(1, entities.size());
        assertTrue(entities.contains(entity1));
    }

    @Test
    @DisplayName("모든 매개변수가 null인 경우 빈 목록을 반환합니다")
    void returnsEmptyListWhenAllParametersAreNull() {
        assertTrue(repository.findAll(
                TestJpqlEntitySpecification.hasName(null)
                        .and(TestJpqlEntitySpecification.hasAge(null))
                        .and(TestJpqlEntitySpecification.hasAddress(null))
        ).isEmpty());
    }
}