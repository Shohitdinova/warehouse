package com.example.warehouse.unit;

import com.example.warehouse.common.service.GenericCrudService;
import com.example.warehouse.unit.dto.UnitCreateDto;
import com.example.warehouse.unit.dto.UnitPatchDto;
import com.example.warehouse.unit.dto.UnitResponseDto;
import com.example.warehouse.unit.dto.UnitUpdateDto;
import com.example.warehouse.unit.entity.Unit;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;



@Service
@Getter
@RequiredArgsConstructor
public class UnitService extends GenericCrudService<Unit, Long, UnitCreateDto, UnitUpdateDto, UnitPatchDto, UnitResponseDto> {

    private final UnitRepository repository;
    private final UnitDtoMapper mapper;
    private final Class<Unit> entityClass = Unit.class;
    private final ModelMapper modelMapper;


    @Override
    protected Unit save(UnitCreateDto createDto) {
        Unit entity = mapper.toEntity(createDto);
        return repository.save(entity);
    }


    @Override
    protected Unit updateEntity(UnitUpdateDto updateDto, Unit unit) {
        mapper.update(updateDto, unit);
        return repository.save(unit);
    }






}

