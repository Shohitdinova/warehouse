package com.example.warehouse.warehouseCostItem;

import com.example.warehouse.common.service.GenericDtoMapper;
import com.example.warehouse.warehouseCostItem.dto.WarehouseCostItemCreateDto;
import com.example.warehouse.warehouseCostItem.dto.WarehouseCostItemResponseDto;
import com.example.warehouse.warehouseCostItem.entity.WarehouseCostItem;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class WarehouseCostItemDtoMapper extends GenericDtoMapper<WarehouseCostItem, WarehouseCostItemCreateDto, WarehouseCostItem, WarehouseCostItemResponseDto> {
   private final ModelMapper mapper;

    @Override
    public WarehouseCostItem toEntity(WarehouseCostItemCreateDto warehouseOutputItem) {
        return mapper.map(warehouseOutputItem, WarehouseCostItem.class);
    }

    @Override
    public WarehouseCostItemResponseDto toResponseDto(WarehouseCostItem warehouse) {
        return mapper.map(warehouse, WarehouseCostItemResponseDto.class);
    }

    @Override
    public void update(WarehouseCostItem updateDto, WarehouseCostItem warehouse) {
        mapper.map(updateDto, warehouse);
    }

    @Override
    public WarehouseCostItemCreateDto toCreateDto(WarehouseCostItem warehouse) {
        return mapper.map(warehouse, WarehouseCostItemCreateDto.class);
    }
}
