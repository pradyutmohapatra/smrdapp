package com.tatapower.smrd.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgentRequest {

    private Long agentId;
    @NotBlank(message = "Name is required")
    private String agentName;
    @NotBlank(message = "Id is required")
    private Long agencyId;

}
