package com.tatapower.smrd.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "role_master")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    private String roleName;

    private String entityName;
    @OneToOne(mappedBy="roleMaster")
    private Agency agency;
    @OneToOne(mappedBy = "roleMaster")
    private Agent agent;
}
