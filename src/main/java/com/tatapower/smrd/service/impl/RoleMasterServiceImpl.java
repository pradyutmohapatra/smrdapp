package com.tatapower.smrd.service.impl;

import com.tatapower.smrd.dto.RoleMasterRequest;
import com.tatapower.smrd.entity.RoleMaster;
import com.tatapower.smrd.repository.RoleMasterRepository;
import com.tatapower.smrd.service.RoleMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleMasterServiceImpl implements RoleMasterService {

    private final RoleMasterRepository roleMasterRepository;

    @Autowired
    public RoleMasterServiceImpl(RoleMasterRepository roleMasterRepository) {
        this.roleMasterRepository = roleMasterRepository;
    }


    @Override
    public RoleMaster saveOrUpdateRoleMaster(RoleMasterRequest roleMasterRequest) {
        RoleMaster roleMaster = (roleMasterRequest.getRoleId() != null)
                ?findRoleMasterById(roleMasterRequest.getRoleId())
                : new RoleMaster();

        roleMaster.setRoleName(roleMasterRequest.getRoleName());
        roleMaster.setEntityName(roleMasterRequest.getEntityName());

        return roleMasterRepository.save(roleMaster);
    }
    private RoleMaster findRoleMasterById(Long roleId) {
        return roleMasterRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("RoleMaster not found with id: " + roleId));
    }


}
