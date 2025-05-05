package com.tatapower.smrd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkingAreaRequestDTO {

    private Long id;
    private String name;
    private Long officeId;
    private Long parentWorkingAreaId;

}
