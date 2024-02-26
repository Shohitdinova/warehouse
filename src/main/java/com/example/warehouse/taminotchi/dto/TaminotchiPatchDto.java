package com.example.warehouse.taminotchi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaminotchiPatchDto {

    @NotBlank
    private String name;

    @NotBlank
    private String phoneNumber;

}
