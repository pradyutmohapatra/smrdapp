package com.tatapower.smrd.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "agent")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agentId;

    private String agentName;
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
}
