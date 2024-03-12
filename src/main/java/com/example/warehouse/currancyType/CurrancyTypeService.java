package com.example.warehouse.currancyType;

import com.example.warehouse.common.service.GenericCrudService;
import com.example.warehouse.currancyType.dto.CurrancyTypeCreateDto;
import com.example.warehouse.currancyType.dto.CurrancyTypePatchDto;
import com.example.warehouse.currancyType.dto.CurrancyTypeResponseDto;
import com.example.warehouse.currancyType.dto.CurrancyTypeUpdateDto;
import com.example.warehouse.currancyType.entity.CurrencyType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;



@Service
@Getter
@RequiredArgsConstructor
public class CurrancyTypeService extends GenericCrudService<CurrencyType, Long, CurrancyTypeCreateDto, CurrancyTypeUpdateDto, CurrancyTypePatchDto, CurrancyTypeResponseDto> {

    private final CurrancyTypeRepository repository;
    private final CurrancyTypeDtoMapper mapper;
    private final Class<CurrencyType> entityClass = CurrencyType.class;
    private final ModelMapper modelMapper;


    @Override
    protected CurrencyType save(CurrancyTypeCreateDto createDto) {
        CurrencyType currencyType = mapper.toEntity(createDto);
        return repository.save(currencyType);
    }

    @Override
    protected CurrencyType updateEntity(CurrancyTypeUpdateDto updateDto, CurrencyType currancyType) {
        mapper.update(updateDto, currancyType);
        return repository.save(currancyType);
    }






}

