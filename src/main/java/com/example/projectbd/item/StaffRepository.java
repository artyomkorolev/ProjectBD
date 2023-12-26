package com.example.projectbd.item;

import com.example.projectbd.item.model.StaffItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<StaffItem,Integer>, JpaSpecificationExecutor<StaffItem> {


}
