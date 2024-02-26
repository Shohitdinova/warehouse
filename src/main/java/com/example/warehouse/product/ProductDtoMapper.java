package com.example.warehouse.product;
import com.example.warehouse.common.service.GenericDtoMapper;
import com.example.warehouse.product.dto.ProductCreateDto;
import com.example.warehouse.product.dto.ProductResponseDto;
import com.example.warehouse.product.dto.ProductUpdateDto;
import com.example.warehouse.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductDtoMapper extends GenericDtoMapper<Product, ProductCreateDto, ProductUpdateDto, ProductResponseDto> {

    private final ModelMapper mapper;

    @Override
    public Product toEntity(ProductCreateDto createDto) {
        return mapper.map(createDto, Product.class);
    }

    @Override
    public ProductResponseDto toResponseDto(Product product) {
        return mapper.map(product, ProductResponseDto.class);
    }

    @Override
    public void update(ProductUpdateDto updateDto, Product product) {
        mapper.map(updateDto, product);
    }

    @Override
    public ProductCreateDto toCreateDto(Product product) {
        return mapper.map(product, ProductCreateDto.class);
    }
}
