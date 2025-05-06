package com.tatapower.smrd.service.impl;

import com.tatapower.smrd.dto.DiscomRequest;
import com.tatapower.smrd.entity.Discom;
import com.tatapower.smrd.repository.DepartmentRepository;
import com.tatapower.smrd.repository.DiscomRepository;
import com.tatapower.smrd.service.DiscomService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscomServiceImpl implements DiscomService {

    private final DiscomRepository discomRepository;

    @Autowired
    public DiscomServiceImpl(DiscomRepository discomRepository, DepartmentRepository departmentRepository) {
        this.discomRepository = discomRepository;
    }

    @Override
    public Discom saveDiscom(DiscomRequest discomRequest) {
        Discom discom = (discomRequest.getId() != null)
                ? discomRepository.findById(discomRequest.getId())
                .orElseThrow(() -> new EntityNotFoundException("Discom not found with id: " +discomRequest.getId()))
                : new Discom();

        discom.setDiscomName(discomRequest.getName());
        return discomRepository.save(discom);
    }
}
