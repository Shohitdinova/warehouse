package com.example.warehouse.categoty;
import com.example.warehouse.categoty.dto.CategoryCreateDto;
import com.example.warehouse.categoty.dto.CategoryResponseDto;
import com.example.warehouse.categoty.dto.CategoryUpdateDto;
import com.example.warehouse.categoty.entity.Category;
import com.example.warehouse.common.service.GenericDtoMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryDtoMapper extends GenericDtoMapper<Category, CategoryCreateDto, CategoryUpdateDto, CategoryResponseDto> {

    private final ModelMapper mapper;

    @Override
    public Category toEntity(CategoryCreateDto createDto) {
        return mapper.map(createDto, Category.class);
    }


    @Override
    public CategoryResponseDto toResponseDto(Category category) {
        return mapper.map(category, CategoryResponseDto.class);
    }

    @Override
    public void update(CategoryUpdateDto updateDto, Category category) {
        mapper.map(updateDto, category);
    }

    @Override
    public CategoryCreateDto toCreateDto(Category category) {
        return mapper.map(category, CategoryCreateDto.class);
    }
}
