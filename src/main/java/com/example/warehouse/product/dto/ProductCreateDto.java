package com.example.warehouse.product.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductCreateDto {


    @NotBlank
    private String name;

    private Long category_id;

  //  private List<String> picture;

    private String accountingCode;

    @NotBlank
    private String productNumber;

    private Long unit_id;


}
