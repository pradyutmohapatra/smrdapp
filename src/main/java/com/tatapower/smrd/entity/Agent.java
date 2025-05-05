package com.tatapower.smrd.entity;


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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agencyId")
    private Agency agency;
}
