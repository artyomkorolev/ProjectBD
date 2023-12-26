package com.example.projectbd.specifications;

import com.example.projectbd.item.model.ClientItem;
import org.springframework.data.jpa.domain.Specification;

public class ClientSpecifications {
    public static Specification<ClientItem> hasFullName(String fullName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("fullName"), "%" + fullName + "%");
    }
}
