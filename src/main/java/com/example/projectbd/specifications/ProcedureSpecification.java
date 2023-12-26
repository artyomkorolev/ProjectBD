package com.example.projectbd.specifications;

import com.example.projectbd.item.model.ClientItem;
import com.example.projectbd.item.model.ProcedureItem;
import org.springframework.data.jpa.domain.Specification;

public class ProcedureSpecification {
    public static Specification<ProcedureItem> hasName(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }
}
