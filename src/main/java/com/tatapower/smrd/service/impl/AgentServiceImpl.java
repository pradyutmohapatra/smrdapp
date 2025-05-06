package com.tatapower.smrd.service.impl;

import com.tatapower.smrd.dto.AgentRequest;
import com.tatapower.smrd.entity.Agency;
import com.tatapower.smrd.entity.Agent;
import com.tatapower.smrd.repository.AgencyRepository;
import com.tatapower.smrd.repository.AgentRepository;
import com.tatapower.smrd.service.AgentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentServiceImpl implements AgentService {

    private final AgentRepository agentRepository;
    private final AgencyRepository agencyRepository;

    @Autowired
    public AgentServiceImpl(AgentRepository agentRepository, AgencyRepository agencyRepository) {
        this.agentRepository = agentRepository;
        this.agencyRepository = agencyRepository;
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
}
