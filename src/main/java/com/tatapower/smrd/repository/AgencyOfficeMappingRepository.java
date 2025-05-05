package com.tatapower.smrd.repository;



import com.tatapower.smrd.entity.AgencyOfficeMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyOfficeMappingRepository extends JpaRepository<AgencyOfficeMapping, Long> {
}
