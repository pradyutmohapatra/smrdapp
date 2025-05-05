package com.tatapower.smrd.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "office")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long officeId;

    private String officeName;

    @ManyToOne
    @JoinColumn(name = "discom_id", nullable = false)
    private Discom discom;

    @ManyToOne
    @JoinColumn(name = "office_level_id", nullable = false)
    private OfficeLevelMaster officeLevelMaster;

    @ManyToOne
    @JoinColumn(name = "parent_office_id")
    private Office parentOffice;
}
