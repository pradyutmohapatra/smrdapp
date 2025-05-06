package com.tatapower.smrd.service.impl;

import com.tatapower.smrd.dto.AgencyRequest;
import com.tatapower.smrd.entity.Agency;
import com.tatapower.smrd.entity.Discom;
import com.tatapower.smrd.repository.AgencyRepository;
import com.tatapower.smrd.repository.DiscomRepository;
import com.tatapower.smrd.service.AgencyService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgencyServiceImpl implements AgencyService {

    private final AgencyRepository agencyRepository;
    private final DiscomRepository discomRepository;

    @Autowired
    public AgencyServiceImpl(AgencyRepository agencyRepository, DiscomRepository discomRepository) {
        this.agencyRepository = agencyRepository;
        this.discomRepository = discomRepository;
    }

    @Override
    public Agency saveOrUpdateAgency(AgencyRequest agencyRequest) {
        Agency agency = (agencyRequest.getAgencyId()!= null)
                ? findAgencyById(agencyRequest.getAgencyId())
                : new Agency();

        agency.setAgencyName(agencyRequest.getAgencyName());

        Discom discom = findDiscomById(agencyRequest.getDiscomId());
        agency.setDiscom(discom);
        return agencyRepository.save(agency);

    }
    private Agency findAgencyById(Long id) {
        return agencyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agency not found with id: " + id));
    }

    private Discom findDiscomById(Long id) {
        return discomRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Discom not found with id: " + id));
    }
}
