package com.tatapower.smrd.service;

import com.tatapower.smrd.dto.OfficeRequestDTO;
import com.tatapower.smrd.dto.SaveWorkTypeRequestDTO;
import com.tatapower.smrd.dto.WorkingAreaRequestDTO;

public interface OfficeService {

    void saveOffice(OfficeRequestDTO officeRequest);

    void saveWorkType(SaveWorkTypeRequestDTO workTypeRequest);

    void saveWorkingArea(WorkingAreaRequestDTO workingAreaRequest);

}
