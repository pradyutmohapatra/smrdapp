package com.tatapower.smrd.service;

import com.tatapower.smrd.dto.AgencyRequest;
import com.tatapower.smrd.entity.Agency;

public interface AgencyService {
    Agency saveOrUpdateAgency(AgencyRequest agency);

}
