package com.example.warehouse.unit;

import com.example.warehouse.unit.dto.UnitCreateDto;
import com.example.warehouse.unit.dto.UnitPatchDto;
import com.example.warehouse.unit.dto.UnitResponseDto;
import com.example.warehouse.unit.dto.UnitUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/unit")
@RequiredArgsConstructor
public class UnitController {

    private final UnitService service;
    @PostMapping
    public ResponseEntity<UnitResponseDto> create(@RequestBody @Valid UnitCreateDto createDto) {
        UnitResponseDto categoryResponseDto = service.create(createDto);
        return ResponseEntity.ok(categoryResponseDto);
    }
    @GetMapping
    public ResponseEntity<Page<UnitResponseDto>> getAll(Pageable pageable, @RequestParam(required = false) String predicate) {
        Page<UnitResponseDto> all = service.getAll(pageable, predicate);
        return ResponseEntity.ok(all);
    }


    @GetMapping("/{id}")
    public ResponseEntity<UnitResponseDto> get(@PathVariable Long id) {
        UnitResponseDto responseDto = service.getById(id);
        return ResponseEntity.ok(responseDto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<UnitResponseDto> update(@PathVariable Long id, @RequestBody @Valid UnitUpdateDto updateDto) {
        UnitResponseDto responseDto = service.update(id, updateDto);
        return ResponseEntity.ok(responseDto);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<UnitResponseDto> patch(@PathVariable Long id, @RequestBody UnitPatchDto patchDto) throws NoSuchFieldException, IllegalAccessException {
        UnitResponseDto responseDto = service.patch(id, patchDto);
        return ResponseEntity.ok(responseDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
