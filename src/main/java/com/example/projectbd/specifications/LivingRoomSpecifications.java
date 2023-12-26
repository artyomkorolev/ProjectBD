package com.example.projectbd.specifications;

import com.example.projectbd.item.model.ClientItem;
import com.example.projectbd.item.model.LivingRoomItem;
import org.springframework.data.jpa.domain.Specification;

public class LivingRoomSpecifications {
    public static Specification<LivingRoomItem> hasStatus(boolean status) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), status);
    }
}
