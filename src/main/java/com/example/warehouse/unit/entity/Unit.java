package com.example.warehouse.unit.entity;

import com.example.warehouse.common.abstractClass.AbsClass;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Unit extends AbsClass {

    @NotBlank
    @Column(unique = true, nullable = false)
    private String name;

    private Boolean status;


}
