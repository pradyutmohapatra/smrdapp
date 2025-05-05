package com.tatapower.smrd.dto;

import lombok.Data;
import lombok.Getter;

import java.util.List;

public record AgentRequestDTO(Long id, String name, Long agencyId, List<Long> workTypeIds, List<Long> workingAreas,
                              String phoneNumber) {

}
