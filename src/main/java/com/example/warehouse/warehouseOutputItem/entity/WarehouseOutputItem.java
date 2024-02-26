package com.example.warehouse.warehouseOutputItem.entity;

import com.example.warehouse.common.abstractClass.AbsClass;
import com.example.warehouse.product.entity.Product;
import com.example.warehouse.warehouseOutput.entity.WarehouseOutput;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class WarehouseOutputItem extends AbsClass {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private double count;
    @Column (nullable = false)
    private double product_price;

    @ManyToOne
    @JoinColumn(name = "warehouse_output_id")
    private WarehouseOutput warehouseOutput;

}
