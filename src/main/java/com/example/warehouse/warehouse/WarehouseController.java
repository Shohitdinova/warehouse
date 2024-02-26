package com.example.warehouse.warehouse;

import com.example.warehouse.warehouse.dto.WarehouseCreateDto;
import com.example.warehouse.warehouse.dto.WarehousePatchDto;
import com.example.warehouse.warehouse.dto.WarehouseResponseDto;
import com.example.warehouse.warehouse.dto.WarehouseUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warehouse")
@RequiredArgsConstructor
public class WarehouseController {

    private final WarehouseService service;

    @PostMapping
    public ResponseEntity<WarehouseResponseDto> create(@RequestBody @Valid WarehouseCreateDto createDto) {
        WarehouseResponseDto categoryResponseDto = service.create(createDto);
        return ResponseEntity.ok(categoryResponseDto);
    }
    @GetMapping
    public ResponseEntity<Page<WarehouseResponseDto>> getAll(Pageable pageable, @RequestParam(required = false) String predicate)
    {
        Page<WarehouseResponseDto> all = service.getAll(pageable, predicate);
        return ResponseEntity.ok(all);
    }


    @GetMapping("/{id}")
    public ResponseEntity<WarehouseResponseDto> get(@PathVariable Long id) {
        WarehouseResponseDto responseDto = service.getById(id);
        return ResponseEntity.ok(responseDto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<WarehouseResponseDto> update(@PathVariable Long id, @RequestBody @Valid WarehouseUpdateDto updateDto) {
        WarehouseResponseDto responseDto = service.update(id, updateDto);
        return ResponseEntity.ok(responseDto);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<WarehouseResponseDto> patch(@PathVariable Long id, @RequestBody WarehousePatchDto patchDto) throws NoSuchFieldException, IllegalAccessException {
        WarehouseResponseDto responseDto = service.patch(id, patchDto);
        return ResponseEntity.ok(responseDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
