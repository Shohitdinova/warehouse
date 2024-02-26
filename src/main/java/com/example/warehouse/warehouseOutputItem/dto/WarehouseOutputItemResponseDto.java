package com.example.warehouse.warehouseOutputItem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WarehouseOutputItemResponseDto {
    private Long id;
    private Long productId;
    private double count;
    private double productPrice;

}
