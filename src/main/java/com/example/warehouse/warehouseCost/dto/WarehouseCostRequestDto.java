package com.example.warehouse.warehouseCost.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WarehouseCostRequestDto {
    private LocalDate date;
    private Long warehouseId;
    private Long taminotchiId;
    private Long warehouseCostItemId;



}
