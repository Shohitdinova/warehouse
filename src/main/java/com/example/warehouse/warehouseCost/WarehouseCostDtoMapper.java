package com.example.warehouse.warehouseCost;
import com.example.warehouse.common.service.GenericDtoMapper;
import com.example.warehouse.warehouseCost.dto.WarehouseCostCreateDto;
import com.example.warehouse.warehouseCost.dto.WarehouseCostResponseDto;
import com.example.warehouse.warehouseCost.dto.WarehouseCostUpdateDto;
import com.example.warehouse.warehouseCost.entity.WarehouseCost;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class


WarehouseCostDtoMapper extends GenericDtoMapper<WarehouseCost, WarehouseCostCreateDto, WarehouseCostUpdateDto,WarehouseCostResponseDto> {

    private final ModelMapper mapper;

    @Override
    public WarehouseCost toEntity(WarehouseCostCreateDto createDto) {
        return mapper.map(createDto, WarehouseCost.class);
    }

    @Override
    public WarehouseCostResponseDto toResponseDto(WarehouseCost warehouseCost) {
        return mapper.map(warehouseCost, WarehouseCostResponseDto.class);
    }

    @Override
    public void update(WarehouseCostUpdateDto updateDto, WarehouseCost warehouseCost) {
        mapper.map(updateDto, warehouseCost);
    }

    @Override
    public WarehouseCostCreateDto toCreateDto(WarehouseCost warehouseCost) {
        return mapper.map(warehouseCost, WarehouseCostCreateDto.class);
    }
}
