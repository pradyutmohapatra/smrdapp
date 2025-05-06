package com.tatapower.smrd.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgencyRequest{

   private Long agencyId;
    @NotBlank(message = "Name is required")
    private String agencyName;
    @NotBlank(message = "Name is required")
    private Long discomId;

}

