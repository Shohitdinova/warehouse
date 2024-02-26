package com.example.warehouse.worker.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkerCreateDto {

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
    private Long warehouse_id;

}
