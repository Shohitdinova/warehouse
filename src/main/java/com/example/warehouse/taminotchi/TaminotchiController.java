package com.example.warehouse.taminotchi;

import com.example.warehouse.taminotchi.dto.TaminotchiCreateDto;
import com.example.warehouse.taminotchi.dto.TaminotchiPatchDto;
import com.example.warehouse.taminotchi.dto.TaminotchiResponseDto;
import com.example.warehouse.taminotchi.dto.TaminotchiUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/taminotchi")
@RequiredArgsConstructor
public class TaminotchiController {

    private final TaminotchiService service;

    @PostMapping
    public ResponseEntity<TaminotchiResponseDto> create(@RequestBody @Valid TaminotchiCreateDto createDto) {
        TaminotchiResponseDto categoryResponseDto = service.create(createDto);
        return ResponseEntity.ok(categoryResponseDto);
    }
    @GetMapping
    public ResponseEntity<Page<TaminotchiResponseDto>> getAll(Pageable pageable, @RequestParam(required = false) String predicate) {
        Page<TaminotchiResponseDto> all = service.getAll(pageable, predicate);
        return ResponseEntity.ok(all);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TaminotchiResponseDto> get(@PathVariable Long id) {
        TaminotchiResponseDto responseDto = service.getById(id);
        return ResponseEntity.ok(responseDto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<TaminotchiResponseDto> update(@PathVariable Long id, @RequestBody @Valid TaminotchiUpdateDto updateDto) {
        TaminotchiResponseDto responseDto = service.update(id, updateDto);
        return ResponseEntity.ok(responseDto);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<TaminotchiResponseDto> patch(@PathVariable Long id, @RequestBody TaminotchiPatchDto patchDto) throws NoSuchFieldException, IllegalAccessException {
        TaminotchiResponseDto responseDto = service.patch(id, patchDto);
        return ResponseEntity.ok(responseDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
