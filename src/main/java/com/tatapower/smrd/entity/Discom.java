package com.tatapower.smrd.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "discom")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Discom {

    @Id
    private Long discomId;

    private String name;

    public Long getDiscomId() {
        return discomId;
    }

    public void setDiscomId(Long discomId) {
        this.discomId = discomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
