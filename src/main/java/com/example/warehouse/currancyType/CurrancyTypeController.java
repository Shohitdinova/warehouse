package com.example.warehouse.currancyType;

import com.example.warehouse.currancyType.dto.CurrancyTypeCreateDto;
import com.example.warehouse.currancyType.dto.CurrancyTypePatchDto;
import com.example.warehouse.currancyType.dto.CurrancyTypeResponseDto;
import com.example.warehouse.currancyType.dto.CurrancyTypeUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/currancyType")
@RequiredArgsConstructor
public class CurrancyTypeController {

    private final CurrancyTypeService service;
    @PostMapping
    public ResponseEntity<CurrancyTypeResponseDto> create(@RequestBody @Valid CurrancyTypeCreateDto createDto) {
        CurrancyTypeResponseDto categoryResponseDto = service.create(createDto);
        return ResponseEntity.ok(categoryResponseDto);
    }

    @GetMapping
    public ResponseEntity<Page<CurrancyTypeResponseDto>> getAll(Pageable pageable, @RequestParam(required = false) String predicate) {
        Page<CurrancyTypeResponseDto> all = service.getAll(pageable, predicate);
        return ResponseEntity.ok(all);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CurrancyTypeResponseDto> get(@PathVariable Long id) {
        CurrancyTypeResponseDto responseDto = service.getById(id);
        return ResponseEntity.ok(responseDto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<CurrancyTypeResponseDto> update(@PathVariable Long id, @RequestBody @Valid CurrancyTypeUpdateDto updateDto) {
        CurrancyTypeResponseDto responseDto = service.update(id, updateDto);
        return ResponseEntity.ok(responseDto);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<CurrancyTypeResponseDto> patch(@PathVariable Long id, @RequestBody CurrancyTypePatchDto patchDto) throws NoSuchFieldException, IllegalAccessException {
        CurrancyTypeResponseDto responseDto = service.patch(id, patchDto);
        return ResponseEntity.ok(responseDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
