package com.tatapower.smrd.repository;

import com.tatapower.smrd.entity.WorkType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkTypeRepository extends JpaRepository<WorkType, Long> {
}
