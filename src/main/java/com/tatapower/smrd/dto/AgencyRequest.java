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
    @NotBlank(message = "Name is required")
    private String agencyAdress;
    @NotBlank(message = "Name is required")
    private String email;
    @NotBlank(message = "Name is required")
    private String personalMobile;
    @NotBlank(message = "Name is required")
    private String officeMobile;
    @NotBlank(message = "Name is required")
    private String userName;
    @NotBlank(message = "Name is required")
    private Long roleId;
    @NotBlank(message = "Name is required")
    private Long workTypeId;
    /*@NotBlank(message = "Name is required")
    private Long agentId;*/


}

