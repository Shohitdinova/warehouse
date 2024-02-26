package com.example.warehouse.warehouseCostItem.dto;

import com.example.warehouse.common.abstractClass.AbsClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WarehouseCostItemResponseDto extends AbsClass {
    private Long id;
    private double count;

    private double price;


}
