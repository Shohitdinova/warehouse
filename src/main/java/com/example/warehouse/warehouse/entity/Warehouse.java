package com.example.warehouse.warehouse.entity;

import com.example.warehouse.common.abstractClass.AbsClass;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "warehouse")
//@Where(status = true)
public class Warehouse extends AbsClass {

    @NotBlank
    @Column(name ="warehouse_name", unique = true,nullable = false )
    private String name;
    private Boolean status;
//
//    @OneToMany(mappedBy = "warehouse")
//    private List<Worker> workers;
//
//    @OneToMany(mappedBy = "warehouse")
//    private List<WarehouseCost> warehouseCosts;
//
//    @OneToMany(mappedBy = "warehouse")
//    private List<WarehouseOutput> warehouseOutputs;
//

}
