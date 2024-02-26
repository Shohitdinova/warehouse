package com.example.warehouse.warehouseOutput;

import com.example.warehouse.common.service.GenericDtoMapper;
import com.example.warehouse.warehouseOutput.dto.WarehouseOutputCreateDto;
import com.example.warehouse.warehouseOutput.dto.WarehouseOutputResponseDto;
import com.example.warehouse.warehouseOutput.dto.WarehouseOutputUpdateDto;
import com.example.warehouse.warehouseOutput.entity.WarehouseOutput;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WarehouseOutputDtoMapper extends GenericDtoMapper<WarehouseOutput, WarehouseOutputCreateDto, WarehouseOutputUpdateDto, WarehouseOutputResponseDto> {

    private final ModelMapper mapper;
    @Override
    public WarehouseOutput toEntity(WarehouseOutputCreateDto warehouseOutputRequestDto) {
        return mapper.map(warehouseOutputRequestDto, WarehouseOutput.class);    }

    @Override
    public WarehouseOutputResponseDto toResponseDto(WarehouseOutput warehouseOutput) {
        return mapper.map(warehouseOutput, WarehouseOutputResponseDto.class);    }

    @Override
    public void update(WarehouseOutputUpdateDto updateDto, WarehouseOutput warehouseOutput2) {
        mapper.map(updateDto, warehouseOutput2);
    }

    @Override
    public WarehouseOutputCreateDto toCreateDto(WarehouseOutput warehouseOutput) {
        return mapper.map(warehouseOutput, WarehouseOutputCreateDto.class);    }
}
