package com.tatapower.smrd.service;

import com.tatapower.smrd.dto.DiscomRequest;
import com.tatapower.smrd.entity.Discom;

public interface DiscomService {
    Discom saveDiscom(DiscomRequest discomRequest);
}
