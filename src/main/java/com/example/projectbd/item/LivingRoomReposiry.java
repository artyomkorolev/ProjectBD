package com.example.projectbd.item;

import com.example.projectbd.item.model.ClientItem;
import com.example.projectbd.item.model.LivingRoomItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LivingRoomReposiry extends JpaRepository<LivingRoomItem, Integer>, JpaSpecificationExecutor<LivingRoomItem> {
}
