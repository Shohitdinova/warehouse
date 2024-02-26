package com.example.warehouse.warehouseOutput.dto;

import com.example.warehouse.warehouseOutputItem.dto.WarehouseOutputItemCreateDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WarehouseOutputCreateDto {
    private LocalDate date;
    private Long warehouseId;

    private List<WarehouseOutputItemCreateDto> warehouseOutputItemList;
    private Long currencyTypeId;
    private String costCode;



}
