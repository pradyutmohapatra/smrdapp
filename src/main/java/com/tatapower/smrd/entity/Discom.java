package com.tatapower.smrd.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "discom")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Discom{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discomId;
    private String discomName;
//    @OneToMany(mappedBy = "discom", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Department> departments;
//    @OneToMany(mappedBy = "discom", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Agency> agencies;

}
