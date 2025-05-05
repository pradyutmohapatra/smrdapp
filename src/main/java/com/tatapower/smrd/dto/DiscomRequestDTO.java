package com.tatapower.smrd.dto;

import lombok.Data;

import java.util.List;

public record DiscomRequestDTO(Long id, String name, List<String> officeLevels, List<DeptRequestDTO> departments) {

}
