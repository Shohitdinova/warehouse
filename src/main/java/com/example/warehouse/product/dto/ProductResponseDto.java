package com.example.warehouse.product.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponseDto {


    @NotBlank
    private String name;


    @NotBlank
    private String accountingCode;


}
