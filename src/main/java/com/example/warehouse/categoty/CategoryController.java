package com.example.warehouse.categoty;

import com.example.warehouse.categoty.dto.CategoryCreateDto;
import com.example.warehouse.categoty.dto.CategoryPatchDto;
import com.example.warehouse.categoty.dto.CategoryResponseDto;
import com.example.warehouse.categoty.dto.CategoryUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;
    @PostMapping
    public ResponseEntity<CategoryResponseDto> createCategory(@RequestBody @Valid CategoryCreateDto categoryCreateDto) {
        CategoryResponseDto categoryResponseDto = service.create(categoryCreateDto);
        return ResponseEntity.ok(categoryResponseDto);
    }

    @GetMapping
    public ResponseEntity<Page<CategoryResponseDto>> getAll(Pageable pageable, @RequestParam(required = false) String predicate) {
        Page<CategoryResponseDto> all = service.getAll(pageable, predicate);
        return ResponseEntity.ok(all);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> get(@PathVariable Long id) {
        CategoryResponseDto responseDto = service.getById(id);
        return ResponseEntity.ok(responseDto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> update(@PathVariable Long id, @RequestBody @Valid CategoryUpdateDto updateDto) {
        CategoryResponseDto responseDto = service.update(id, updateDto);
        return ResponseEntity.ok(responseDto);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> patchA(@PathVariable Long id, @RequestBody CategoryPatchDto patchDto) throws NoSuchFieldException, IllegalAccessException {
        CategoryResponseDto responseDto = service.patch(id, patchDto);
        return ResponseEntity.ok(responseDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
