package com.tatapower.smrd.service;

import com.tatapower.smrd.dto.DepartmentRequest;
import com.tatapower.smrd.entity.Department;
public interface DepartmentService {

    Department saveOrUpdateDepartment(DepartmentRequest departmentRequest);
}
