package com.tatapower.smrd.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

        private Long userId;

        @NotBlank(message = "Name is required")
        private String name;

        @NotBlank(message = "Phone number is required")
        private String phoneNumber;

        @NotNull(message = "Discom ID is required")
        private Long discomId;

        @NotNull(message = "Department ID is required")
        private Long departmentId;

        @NotNull(message = "Agency ID is required")
        private Long agencyId;

        @NotNull(message = "Agent ID is required")
        private Long agentId;

        @NotNull(message = "Role ID is required")
        private Long roleId;

    }


