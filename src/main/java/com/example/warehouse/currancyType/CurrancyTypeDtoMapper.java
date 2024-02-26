package com.example.warehouse.currancyType;
import com.example.warehouse.common.service.GenericDtoMapper;
import com.example.warehouse.currancyType.dto.CurrancyTypeCreateDto;
import com.example.warehouse.currancyType.dto.CurrancyTypeResponseDto;
import com.example.warehouse.currancyType.dto.CurrancyTypeUpdateDto;
import com.example.warehouse.currancyType.entity.CurrencyType;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CurrancyTypeDtoMapper extends GenericDtoMapper<CurrencyType, CurrancyTypeCreateDto, CurrancyTypeUpdateDto, CurrancyTypeResponseDto> {

    private final ModelMapper mapper;

    @Override
    public CurrencyType toEntity(CurrancyTypeCreateDto createDto) {
        return mapper.map(createDto, CurrencyType.class);
    }

    @Override
    public CurrancyTypeResponseDto toResponseDto(CurrencyType currancyType) {
        return mapper.map(currancyType, CurrancyTypeResponseDto.class);
    }

    @Override
    public void update(CurrancyTypeUpdateDto updateDto, CurrencyType currancyType) {
        mapper.map(updateDto, currancyType);
    }

    @Override
    public CurrancyTypeCreateDto toCreateDto(CurrencyType currancyType) {
        return mapper.map(currancyType, CurrancyTypeCreateDto.class);
    }
}
