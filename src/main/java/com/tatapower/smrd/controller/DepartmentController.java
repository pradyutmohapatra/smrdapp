package com.tatapower.smrd.controller;

import com.tatapower.smrd.dto.DepartmentRequest;
import com.tatapower.smrd.dto.RoleMasterRequest;
import com.tatapower.smrd.entity.Department;
import com.tatapower.smrd.entity.RoleMaster;
import com.tatapower.smrd.service.DepartmentService;
import com.tatapower.smrd.service.RoleMasterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;
    private final RoleMasterService roleMasterService;

    @Autowired
    public DepartmentController(DepartmentService departmentService,RoleMasterService roleMasterService) {
        this.departmentService = departmentService;
        this.roleMasterService=roleMasterService;
    }

    @PostMapping("/saveDepartment")
    public ResponseEntity<Department> saveOrUpdate(@Valid @RequestBody DepartmentRequest request) {
        Department savedDepartment = departmentService.saveOrUpdateDepartment(request);
        return ResponseEntity.ok(savedDepartment);
    }
    @PostMapping("/saveRoleMaster")
    public ResponseEntity<RoleMaster> saveOrUpdateRoleMaster(@Valid @RequestBody RoleMasterRequest request) {
        RoleMaster savedRoleMaster = roleMasterService.saveOrUpdateRoleMaster(request);
        return ResponseEntity.ok(savedRoleMaster);
    }
}
