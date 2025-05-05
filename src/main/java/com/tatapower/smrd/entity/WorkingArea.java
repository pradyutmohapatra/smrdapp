package com.tatapower.smrd.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "working_area")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkingArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workingAreaId;

    private String areaName;

    @ManyToMany
    @JoinTable(
            name = "agentWorkingkAreaMapping",
            joinColumns = @JoinColumn(name="workAreaId"),inverseJoinColumns = @JoinColumn(name="agentId")

    )
    private List<Agent> agents;

    @ManyToOne
    @JoinColumn(
            name="officeId"
    )
    private Office office;

    @OneToMany
    @JoinColumn(name="parentWorkingAreaId")
    private List<WorkingArea> workingAreas;
}
