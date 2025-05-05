package com.tatapower.smrd.service.impl;

import com.tatapower.smrd.dto.DeptRequestDTO;
import com.tatapower.smrd.dto.DiscomRequestDTO;
import com.tatapower.smrd.entity.Department;
import com.tatapower.smrd.entity.Discom;
import com.tatapower.smrd.repository.DepartmentRepository;
import com.tatapower.smrd.repository.DiscomRepository;
import com.tatapower.smrd.service.DiscomService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscomServiceImpl implements DiscomService {

    private final DiscomRepository discomRepository;
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    @Autowired
    public DiscomServiceImpl(DiscomRepository discomRepository, DepartmentRepository departmentRepository) {
        this.discomRepository = discomRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void saveDiscom(DiscomRequestDTO discomRequestDTO) {
        Discom discom = discomRepository.findById(discomRequestDTO.id()).orElse(new Discom());
        discom.setName(discomRequestDTO.name());
        if (discomRequestDTO.departments() != null) {
            for (DeptRequestDTO d : discomRequestDTO.departments()) {
                Department department = departmentRepository.findById(d.getId()).orElseThrow();
                department.setDiscom(discom);
                departmentRepository.save(department);
            }
        }
        discomRepository.save(discom);
    }
}
