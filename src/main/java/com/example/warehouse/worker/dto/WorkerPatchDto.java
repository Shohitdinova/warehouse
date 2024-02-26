package com.example.warehouse.worker.dto;

import com.example.warehouse.warehouse.dto.WarehouseRequestDto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkerPatchDto {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String userName;

    @NotBlank
    private String password;
    private WarehouseRequestDto warehouse_id;
}
