package com.tatapower.smrd.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleMasterRequest{

    private Long roleId;
    @NotBlank(message = "Name is required")
    private String roleName;
    @NotBlank(message = "Name is required")
    private String entityName;


}
