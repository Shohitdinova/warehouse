package com.example.warehouse.categoty.entity;

import com.example.warehouse.common.abstractClass.AbsClass;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Category extends AbsClass {

   @Column(unique = true,nullable = false)
    private String name;

    private Boolean status;


}
