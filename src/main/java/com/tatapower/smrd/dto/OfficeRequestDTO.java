package com.tatapower.smrd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfficeRequestDTO {
    private Long id;
    private String name;
    private Long discomId;
    private Long parentOfficeId;
    private Long officeLevelMasterId;
}
