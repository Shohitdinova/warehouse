package com.example.warehouse.categoty.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryPatchDto {

    private String name;

    private  Boolean status;

}
