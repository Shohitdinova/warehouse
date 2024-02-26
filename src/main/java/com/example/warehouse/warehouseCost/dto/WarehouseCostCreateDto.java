package com.example.warehouse.warehouseCost.dto;

import com.example.warehouse.warehouseCostItem.dto.WarehouseCostItemCreateDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WarehouseCostCreateDto {
    private LocalDate date;
    private Long warehouseId;
    private Long taminotchiId;
    private List<WarehouseCostItemCreateDto> warehouseCostItems;
    private Long currencyTypeId;
    private String costCode;



}
