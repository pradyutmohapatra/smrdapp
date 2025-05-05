package com.tatapower.smrd.repository;

import com.tatapower.smrd.entity.OfficeLevelMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeLevelMasterRepository extends JpaRepository<OfficeLevelMaster, Long> {
}
