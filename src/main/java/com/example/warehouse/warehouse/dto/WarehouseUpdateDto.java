package com.example.warehouse.warehouse.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WarehouseUpdateDto {

    @NotBlank
    private String name;
    private Boolean status;


}
