package com.example.projectbd.specifications;

import com.example.projectbd.item.model.ClientItem;
import com.example.projectbd.item.model.StaffItem;
import org.springframework.data.jpa.domain.Specification;

public class StaffSpecifications {
    public static Specification<StaffItem> hasFullName(String fullName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("fullName"), "%" + fullName + "%");
    }
}
