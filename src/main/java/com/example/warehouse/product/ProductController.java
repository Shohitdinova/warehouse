package com.example.warehouse.product;

import com.example.warehouse.product.dto.ProductCreateDto;
import com.example.warehouse.product.dto.ProductPatchDto;
import com.example.warehouse.product.dto.ProductResponseDto;
import com.example.warehouse.product.dto.ProductUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<ProductResponseDto> create(@RequestBody @Valid ProductCreateDto createDto) {
        ProductResponseDto categoryResponseDto = service.create(createDto);
        return ResponseEntity.ok(categoryResponseDto);
    }
    @GetMapping
    public ResponseEntity<Page<ProductResponseDto>> getAll(Pageable pageable, @RequestParam(required = false) String predicate) {
        Page<ProductResponseDto> all = service.getAll(pageable, predicate);
        return ResponseEntity.ok(all);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> get(@PathVariable Long id) {
        ProductResponseDto responseDto = service.getById(id);
        return ResponseEntity.ok(responseDto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> update(@PathVariable Long id, @RequestBody @Valid ProductUpdateDto updateDto) {
        ProductResponseDto responseDto = service.update(id, updateDto);
        return ResponseEntity.ok(responseDto);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<ProductResponseDto> patch(@PathVariable Long id, @RequestBody ProductPatchDto patchDto) throws NoSuchFieldException, IllegalAccessException {
        ProductResponseDto responseDto = service.patch(id, patchDto);
        return ResponseEntity.ok(responseDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
