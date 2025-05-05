package com.tatapower.smrd.repository;



import com.tatapower.smrd.entity.Discom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscomRepository extends JpaRepository<Discom, Long> {
}

