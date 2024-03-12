package com.example.warehouse.warehouseCost.dto;

import com.example.warehouse.warehouseCostItem.dto.WarehouseCostItemDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CostDto
{
    private String taminotchiName;
    private String currencyTypeName;
    private String warehouseName;
    private String costCode;
    private List<WarehouseCostItemDto> warehouseCostItemList;
}