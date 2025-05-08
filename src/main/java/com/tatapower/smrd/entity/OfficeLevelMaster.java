package com.tatapower.smrd.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "office_level_master")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfficeLevelMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long officeLevelId;
    private String levelName;

    @ManyToOne
    @JoinColumn(name = "discom_id", nullable = false)
    private Discom discom;
}
