package com.example.warehouse.warehouseOutput.dto;

import com.example.warehouse.warehouseOutputItem.dto.WarehouseOutputItemDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OutputDto {
    private String warehouseName;
    private String currencyTypeName;
    private String costCode;
    private List<WarehouseOutputItemDto> warehouseOutputItemList;


}
