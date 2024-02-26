package com.example.warehouse.warehouse;

import com.example.warehouse.common.service.GenericCrudService;
import com.example.warehouse.warehouse.dto.WarehouseCreateDto;
import com.example.warehouse.warehouse.dto.WarehousePatchDto;
import com.example.warehouse.warehouse.dto.WarehouseResponseDto;
import com.example.warehouse.warehouse.dto.WarehouseUpdateDto;
import com.example.warehouse.warehouse.entity.Warehouse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;



@Service
@Getter
@RequiredArgsConstructor
public class WarehouseService extends GenericCrudService<Warehouse, Long, WarehouseCreateDto, WarehouseUpdateDto, WarehousePatchDto, WarehouseResponseDto> {

    private final WarehouseRepository repository;
    private final WarehouseDtoMapper mapper;
    private final Class<Warehouse> entityClass = Warehouse.class;
    private final ModelMapper modelMapper;


    @Override
    protected Warehouse save(WarehouseCreateDto createDto) {
        Warehouse entity = mapper.toEntity(createDto);
        return repository.save(entity);
    }


    @Override
    protected Warehouse updateEntity(WarehouseUpdateDto updateDto, Warehouse warehouse) {
        mapper.update(updateDto, warehouse);
        return repository.save(warehouse);
    }






}

