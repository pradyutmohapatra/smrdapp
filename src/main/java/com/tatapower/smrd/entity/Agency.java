package com.tatapower.smrd.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "agency")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agencyId;

    private String agencyName;
    private String agencyAdress;
    private String email;
    private String personalMobile;
    private String officeMobile;
    private String userName;
    @OneToOne
    @JoinColumn(name="role_id")
    private RoleMaster  roleMaster;
    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<WorkType> workType;

    @ManyToOne
    @JoinColumn(name = "discom_id", nullable = false)
    private Discom discom;
    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Agent> agents;

}

