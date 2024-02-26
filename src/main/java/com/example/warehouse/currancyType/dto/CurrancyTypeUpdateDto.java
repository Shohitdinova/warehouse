package com.example.warehouse.currancyType.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CurrancyTypeUpdateDto {

    @NotBlank
    private String name;

    private  Boolean status;


}
