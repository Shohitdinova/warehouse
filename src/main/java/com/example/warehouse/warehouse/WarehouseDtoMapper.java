package com.example.warehouse.warehouse;
import com.example.warehouse.common.service.GenericDtoMapper;
import com.example.warehouse.warehouse.dto.WarehouseCreateDto;
import com.example.warehouse.warehouse.dto.WarehouseResponseDto;
import com.example.warehouse.warehouse.dto.WarehouseUpdateDto;
import com.example.warehouse.warehouse.entity.Warehouse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WarehouseDtoMapper extends GenericDtoMapper<Warehouse, WarehouseCreateDto, WarehouseUpdateDto, WarehouseResponseDto> {

    private final ModelMapper mapper;

    @Override
    public Warehouse toEntity(WarehouseCreateDto createDto) {
        return mapper.map(createDto, Warehouse.class);
    }

    @Override
    public WarehouseResponseDto toResponseDto(Warehouse warehouse) {
        return mapper.map(warehouse, WarehouseResponseDto.class);
    }

    @Override
    public void update(WarehouseUpdateDto updateDto, Warehouse warehouse) {
        mapper.map(updateDto, warehouse);
    }

    @Override
    public WarehouseCreateDto toCreateDto(Warehouse warehouse) {
        return mapper.map(warehouse, WarehouseCreateDto.class);
    }
}
