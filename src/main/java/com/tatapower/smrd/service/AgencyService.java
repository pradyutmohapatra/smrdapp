package com.tatapower.smrd.service;

import com.tatapower.smrd.dto.AgencyRequestDTO;
import com.tatapower.smrd.entity.Agency;

public interface AgencyService {
    void saveAgency(AgencyRequestDTO agency);
}
