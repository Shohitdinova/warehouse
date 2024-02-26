package com.example.warehouse.taminotchi;
import com.example.warehouse.common.service.GenericDtoMapper;
import com.example.warehouse.taminotchi.dto.TaminotchiCreateDto;
import com.example.warehouse.taminotchi.dto.TaminotchiResponseDto;
import com.example.warehouse.taminotchi.dto.TaminotchiUpdateDto;
import com.example.warehouse.taminotchi.entity.Taminotchi;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaminotchiDtoMapper extends GenericDtoMapper<Taminotchi, TaminotchiCreateDto, TaminotchiUpdateDto, TaminotchiResponseDto> {

    private final ModelMapper mapper;

    @Override
    public Taminotchi toEntity(TaminotchiCreateDto createDto) {
        return mapper.map(createDto, Taminotchi.class);
    }

    @Override
    public TaminotchiResponseDto toResponseDto(Taminotchi taminotchi) {
        return mapper.map(taminotchi, TaminotchiResponseDto.class);
    }

    @Override
    public void update(TaminotchiUpdateDto updateDto, Taminotchi taminotchi) {
        mapper.map(updateDto, taminotchi);
    }

    @Override
    public TaminotchiCreateDto toCreateDto(Taminotchi taminotchi) {
        return mapper.map(taminotchi, TaminotchiCreateDto.class);
    }
}
