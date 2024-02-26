package com.example.warehouse.unit;
import com.example.warehouse.common.service.GenericDtoMapper;
import com.example.warehouse.unit.dto.UnitCreateDto;
import com.example.warehouse.unit.dto.UnitResponseDto;
import com.example.warehouse.unit.dto.UnitUpdateDto;
import com.example.warehouse.unit.entity.Unit;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UnitDtoMapper extends GenericDtoMapper<Unit, UnitCreateDto, UnitUpdateDto, UnitResponseDto> {

    private final ModelMapper mapper;

    @Override
    public Unit toEntity(UnitCreateDto createDto) {
        return mapper.map(createDto, Unit.class);
    }

    @Override
    public UnitResponseDto toResponseDto(Unit unit) {
        return mapper.map(unit, UnitResponseDto.class);
    }

    @Override
    public void update(UnitUpdateDto updateDto, Unit unit) {
        mapper.map(updateDto, unit);
    }

    @Override
    public UnitCreateDto toCreateDto(Unit unit) {
        return mapper.map(unit, UnitCreateDto.class);
    }
}
