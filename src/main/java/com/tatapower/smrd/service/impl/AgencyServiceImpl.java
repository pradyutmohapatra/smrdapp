package com.tatapower.smrd.service.impl;

import com.tatapower.smrd.dto.AgencyRequestDTO;
import com.tatapower.smrd.entity.Agency;
import com.tatapower.smrd.repository.AgencyRepository;
import com.tatapower.smrd.service.AgencyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgencyServiceImpl implements AgencyService {

    private AgencyRepository agencyRepository;

    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    public AgencyServiceImpl(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @Override
    public void saveAgency(AgencyRequestDTO agency) {

        Agency agencie = modelMapper.map(agency,Agency.class);
        agencyRepository.save(agencie);

    }
}
