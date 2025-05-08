package com.tatapower.smrd.service.impl;

import com.tatapower.smrd.dto.AgencyRequest;
import com.tatapower.smrd.entity.*;
import com.tatapower.smrd.repository.*;
import com.tatapower.smrd.service.AgencyService;
import jakarta.persistence.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyServiceImpl implements AgencyService {

    private final AgencyRepository agencyRepository;
    private final DiscomRepository discomRepository;
    private final RoleMasterRepository roleMasterRepository;
    private final WorkTypeRepository workTypeRepository;
    private final AgentRepository agentRepository;
    @Autowired
    public AgencyServiceImpl(AgencyRepository agencyRepository, DiscomRepository discomRepository, RoleMasterRepository roleMasterRepository, WorkTypeRepository workTypeRepository, AgentRepository agentRepository) {
        this.agencyRepository = agencyRepository;
        this.discomRepository = discomRepository;
        this.roleMasterRepository = roleMasterRepository;
        this.workTypeRepository = workTypeRepository;
        this.agentRepository = agentRepository;
    }

    @Override
    public Agency saveOrUpdateAgency(AgencyRequest agencyRequest) {
        Agency agency = (agencyRequest.getAgencyId()!= null)
                ? findAgencyById(agencyRequest.getAgencyId())
                : new Agency();

        agency.setAgencyName(agencyRequest.getAgencyName());

        Discom discom = findDiscomById(agencyRequest.getDiscomId());
        agency.setDiscom(discom);
        RoleMaster roleMaster=findRoleMaster(agencyRequest.getRoleId());
        agency.setRoleMaster(roleMaster);


        // Could be create exceptation
        WorkType workType = findWorkType(agencyRequest.getWorkTypeId());
        workType.setAgency(agency); // Optional: Set the back-reference if needed
        agency.setWorkType(List.of(workType)); // Set single workType as a list

        // Could be create exceptation
       /* Agent agent = findAgent(agencyRequest.getAgentId());
        agent.setAgency(agency); // Optional: Set the back-reference if needed
        agency.setAgents(List.of(agent));
*/

        //Added by Pradyut
        agency.setAgencyName(agencyRequest.getAgencyName());
        agency.setAgencyAdress(agencyRequest.getAgencyAdress());
        agency.setEmail(agencyRequest.getEmail());
        agency.setPersonalMobile(agencyRequest.getPersonalMobile());
        agency.setOfficeMobile(agencyRequest.getOfficeMobile());
        agency.setUserName(agencyRequest.getUserName());

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

    RoleMaster findRoleMaster(Long id){
        return roleMasterRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + id));


    }
    WorkType findWorkType(Long id) {
        return workTypeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Work Type not found with id: " + id));
    }

 /*   Agent findAgent(Long id) {
        return agentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agent not found with id: " + id));
    }*/
}
