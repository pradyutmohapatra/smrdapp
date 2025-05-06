package com.tatapower.smrd.service.impl;

import com.tatapower.smrd.dto.DepartmentRequest;
import com.tatapower.smrd.entity.Department;
import com.tatapower.smrd.entity.Discom;
import com.tatapower.smrd.repository.DepartmentRepository;
import com.tatapower.smrd.repository.DiscomRepository;
import com.tatapower.smrd.service.DepartmentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DiscomRepository discomRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository,DiscomRepository discomRepository) {
        this.departmentRepository = departmentRepository;
        this.discomRepository=discomRepository;
    }


    @Override
    public Department saveOrUpdateDepartment(DepartmentRequest departmentRequest) {

        Department department = departmentRequest.getId() == null ? new Department() : findDepartmentById(departmentRequest.getId());

        // Set name and associate Discom to the department
        department.setDepartmentName(departmentRequest.getName());
        department.setDiscom(findDiscomById(departmentRequest.getDiscomId()));

        return departmentRepository.save(department);

    }
    private Department findDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + id));
    }
    private Discom findDiscomById(Long discomId) {
        return discomRepository.findById(discomId)
                .orElseThrow(() -> new EntityNotFoundException("Discom not found with id: " + discomId));
    }
}
