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
    @NotBlank(message = "Mobile Number is required")
    private String personalMobile;
    @NotBlank(message = "Mobile Number is required")
    private String officeMobile;
    @NotBlank(message = "name is required")
    private String userName;
    @NotBlank(message = "email is required")
    private String email;
    @NotBlank(message = "Id is required")
    private Long agencyId;
    @NotBlank(message = "Id is required")
    private Long roleId;
    @NotBlank(message = "Id is required")
    private Long workTypeId;


}

/*


private String personalMobile;
    private String officeMobile;
    private String userName;
    private String email;
    @OneToOne
    @JoinColumn(name="worktype_id")
    private WorkType workType;
    @OneToOne
    @JoinColumn(name="role_id")
    private RoleMaster roleMaster;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agencyId")
    @JsonIgnore
    private Agency agency;
 */