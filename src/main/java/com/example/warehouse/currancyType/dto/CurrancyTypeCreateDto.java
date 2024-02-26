package com.example.warehouse.currancyType.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CurrancyTypeCreateDto {

    @NotBlank
    private String name;

    private Boolean status;


}
