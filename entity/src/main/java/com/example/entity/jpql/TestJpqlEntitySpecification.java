package com.example.entity.jpql;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class TestJpqlEntitySpecification {

    public static Specification<TestJpqlEntity> hasName(String name) {
        return (Root<TestJpqlEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            if (name == null) {
                return null;
            }
            return builder.equal(root.get("name"), name);
        };
    }

    public static Specification<TestJpqlEntity> hasAge(Integer age) {
        return (Root<TestJpqlEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            if (age == null) {
                return null;
            }
            return builder.equal(root.get("age"), age);
        };
    }

    public static Specification<TestJpqlEntity> hasAddress(String address) {
        return (Root<TestJpqlEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            if (address == null) {
                return null;
            }
            return builder.equal(root.get("address"), address);
        };
    }
}
