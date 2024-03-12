package com.example.warehouse.warehouseOutputItem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WarehouseOutputItemDto {


    private Long product_id;

    private double count;

    private double price;



}
