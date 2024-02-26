package com.example.warehouse.categoty;

import com.example.warehouse.categoty.dto.CategoryCreateDto;
import com.example.warehouse.categoty.dto.CategoryPatchDto;
import com.example.warehouse.categoty.dto.CategoryResponseDto;
import com.example.warehouse.categoty.dto.CategoryUpdateDto;
import com.example.warehouse.categoty.entity.Category;
import com.example.warehouse.common.service.GenericCrudService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;



@Service
@Getter
@RequiredArgsConstructor
public class CategoryService extends GenericCrudService<Category, Long, CategoryCreateDto, CategoryUpdateDto, CategoryPatchDto, CategoryResponseDto> {

    private final CategoryRepository repository;
    private final CategoryDtoMapper mapper;
    private final Class<Category> entityClass = Category.class;
    private final ModelMapper modelMapper;


    @Override
    protected Category save(CategoryCreateDto createDto) {
        Category category = mapper.toEntity(createDto);
        return repository.save(category);
    }

    @Override
    protected Category updateEntity(CategoryUpdateDto updateDto, Category category) {
        mapper.update(updateDto, category);
        return repository.save(category);
    }






}

