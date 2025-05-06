package com.tatapower.smrd.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentRequest {
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Id is required")
    private Long discomId;

}
