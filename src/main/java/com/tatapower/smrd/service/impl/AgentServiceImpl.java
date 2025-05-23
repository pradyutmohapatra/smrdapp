package com.tatapower.smrd.service.impl;

import com.tatapower.smrd.dto.AgentRequest;
import com.tatapower.smrd.entity.Agency;
import com.tatapower.smrd.entity.Agent;
import com.tatapower.smrd.entity.RoleMaster;
import com.tatapower.smrd.entity.WorkType;
import com.tatapower.smrd.repository.AgencyRepository;
import com.tatapower.smrd.repository.AgentRepository;
import com.tatapower.smrd.repository.RoleMasterRepository;
import com.tatapower.smrd.repository.WorkTypeRepository;
import com.tatapower.smrd.service.AgentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentServiceImpl implements AgentService {

    private final AgentRepository agentRepository;
    private final AgencyRepository agencyRepository;
    private final RoleMasterRepository roleMasterRepository;
    private final WorkTypeRepository workTypeRepository;

    @Autowired
    public AgentServiceImpl(AgentRepository agentRepository, AgencyRepository agencyRepository, RoleMasterRepository roleMasterRepository, WorkTypeRepository workTypeRepository) {
        this.agentRepository = agentRepository;
        this.agencyRepository = agencyRepository;
        this.roleMasterRepository = roleMasterRepository;
        this.workTypeRepository = workTypeRepository;
    }

    @Override
    public Agent saveOrUpdateAgent(AgentRequest agentRequest) {
        Agent agent = (agentRequest.getAgentId() != null)
                ? findAgentById(agentRequest.getAgentId())
                : new Agent();

        // Set name from request
        agent.setAgentName(agentRequest.getAgentName());

        Agency agency = findAgencyById(agentRequest.getAgencyId());
        agent.setAgency(agency);
        WorkType workType=findWorkTypeById(agentRequest.getWorkTypeId());
        agent.setWorkType(workType);
        RoleMaster roleMaster=findRoleMasterById(agentRequest.getRoleId());
        agent.setRoleMaster(roleMaster);
        agent.setEmail(agentRequest.getEmail());
        agent.setOfficeMobile(agentRequest.getOfficeMobile());

// Added new
        agent.setPersonalMobile(agentRequest.getPersonalMobile());
        agent.setUserName(agentRequest.getUserName());


       /* agent.setPersonalMobile(agent.getPersonalMobile());
        agent.setUserName(agent.getUserName());*/
        // Save and return
        return agentRepository.save(agent);
    }
    private Agent findAgentById(Long id) {
        return agentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agent not found with id: " + id));
    }

    private Agency findAgencyById(Long id) {
        return agencyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agency not found with id: " + id));
    }
    private WorkType findWorkTypeById(Long id) {
        return workTypeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("WorkType not found with id: " + id));
    }
    private RoleMaster findRoleMasterById(Long id) {
        return roleMasterRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("RoleMaster not found with id: " + id));
    }
}
