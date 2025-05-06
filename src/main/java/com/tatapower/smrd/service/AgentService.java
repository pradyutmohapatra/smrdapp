package com.tatapower.smrd.service;

import com.tatapower.smrd.dto.AgentRequest;
import com.tatapower.smrd.entity.Agent;

public interface AgentService {

    Agent saveOrUpdateAgent(AgentRequest agentRequest);
}
