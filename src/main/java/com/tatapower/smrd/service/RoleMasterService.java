package com.tatapower.smrd.service;

import com.tatapower.smrd.dto.RoleMasterRequest;
import com.tatapower.smrd.entity.RoleMaster;

public interface RoleMasterService {

    public RoleMaster saveOrUpdateRoleMaster(RoleMasterRequest roleMasterRequest);
}
