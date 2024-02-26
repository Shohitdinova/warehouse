package com.example.warehouse.taminotchi;

import com.example.warehouse.common.service.GenericCrudService;
import com.example.warehouse.taminotchi.dto.TaminotchiCreateDto;
import com.example.warehouse.taminotchi.dto.TaminotchiPatchDto;
import com.example.warehouse.taminotchi.dto.TaminotchiResponseDto;
import com.example.warehouse.taminotchi.dto.TaminotchiUpdateDto;
import com.example.warehouse.taminotchi.entity.Taminotchi;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@Getter
@RequiredArgsConstructor
public class TaminotchiService extends GenericCrudService<Taminotchi, Long, TaminotchiCreateDto, TaminotchiUpdateDto, TaminotchiPatchDto, TaminotchiResponseDto> {

    private final TaminotchiRepository repository;
    private final TaminotchiDtoMapper mapper;
    private final Class<Taminotchi> entityClass = Taminotchi.class;
    private final ModelMapper modelMapper;


    @Override
    protected Taminotchi save(TaminotchiCreateDto createDto) {
        Taminotchi taminotchi = new Taminotchi();
        taminotchi.setName(createDto.getName());
        taminotchi.setPhoneNumber((createDto.getPhoneNumber()));
        return repository.save(taminotchi);
    }

    @Override
    protected Taminotchi updateEntity(TaminotchiUpdateDto updateDto, Taminotchi taminotchi) {
        mapper.update(updateDto, taminotchi);
        return repository.save(taminotchi);
    }





}

