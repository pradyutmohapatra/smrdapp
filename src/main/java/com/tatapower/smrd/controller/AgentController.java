package com.tatapower.smrd.controller;
import com.tatapower.smrd.dto.AgentRequest;
import com.tatapower.smrd.entity.Agent;
import com.tatapower.smrd.service.AgentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agent")
public class AgentController {

    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @PostMapping("/saveAgent")
    public ResponseEntity<Agent> saveOrUpdate(@Valid @RequestBody AgentRequest agentRequest) {
        Agent agent = agentService.saveOrUpdateAgent(agentRequest);
        return ResponseEntity.ok(agent);
    }
}
