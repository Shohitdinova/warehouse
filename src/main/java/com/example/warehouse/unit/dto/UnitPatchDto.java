package com.example.warehouse.unit.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class UnitPatchDto {

    @NotBlank
    private String name;

    private Boolean status;
}
