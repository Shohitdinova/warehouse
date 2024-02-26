package com.example.warehouse.taminotchi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaminotchiResponseDto {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String phoneNumber;

}
