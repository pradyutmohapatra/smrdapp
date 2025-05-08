package com.tatapower.smrd.entity;




import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "work_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workTypeId;

    private String workTypeName;


    @ManyToOne
    @JoinColumn(name="discomId")
    private Discom discom;

    @OneToOne(mappedBy="workType")
    private Agent agent;
    @ManyToOne
    private Agency agency;
}
