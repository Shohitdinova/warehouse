package com.example.warehouse.warehouseOutput.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WarehouseOutputRequestDto
{

    private Long warehouseId;
    private Long curranncyTypeId;
    @NotBlank
    private String invoiceNumber;

}
