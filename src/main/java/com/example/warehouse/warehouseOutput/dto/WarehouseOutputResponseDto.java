package com.example.warehouse.warehouseOutput.dto;

import com.example.warehouse.currancyType.entity.CurrencyType;
import com.example.warehouse.warehouse.entity.Warehouse;
import com.example.warehouse.warehouseOutputItem.entity.WarehouseOutputItem;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WarehouseOutputResponseDto {


    private Long id;

    private Warehouse warehouse;

    private CurrencyType currencyType;


    private List<WarehouseOutputItem> warehouseOutputItems = new ArrayList<>();


    @NotBlank
    private String invoiceNumber;

}
