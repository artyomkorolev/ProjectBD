package com.example.projectbd.item;

import com.example.projectbd.item.model.ClientItem;
import com.example.projectbd.item.model.StaffItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<ClientItem, Integer>, JpaSpecificationExecutor<ClientItem> {
}
