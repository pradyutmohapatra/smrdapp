package com.tatapower.smrd.repository;

import com.tatapower.smrd.entity.WorkingArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingAreaRepository extends JpaRepository<WorkingArea, Long> {
}
