package com.repository.specification;

import org.springframework.data.jpa.domain.Specification;
import com.entity.Cab;

public class CabSpecification {
    public static Specification<Cab> hasType(Integer type) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("type"), type);
    }

    public static Specification<Cab> hasFrom(String from) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("cabFrom"), from);
    }

    public static Specification<Cab> hasTo(String to) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("cabTo"), to);
    }

    public static Specification<Cab> hasAvailable(Boolean available) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("isAvailable"), available);
    }

    public static Specification<Cab> hasAmountFrom(long amountFrom) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("amount"), amountFrom);
    }

    public static Specification<Cab> hasAmountTo(long amountTo) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("amount"), amountTo);
    }
}