package com.example.warehouse.warehouseOutputItem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WarehouseOutputItemCreateDto {

    private Long product;

    private double count;

    private double product_price;
}