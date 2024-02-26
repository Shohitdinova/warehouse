package com.example.warehouse.worker;

import com.example.warehouse.worker.dto.WorkerCreateDto;
import com.example.warehouse.worker.dto.WorkerPatchDto;
import com.example.warehouse.worker.dto.WorkerResponseDto;
import com.example.warehouse.worker.dto.WorkerUpdateDto;
import com.example.warehouse.worker.entity.Worker;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/worker")
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerService service;

    @PostMapping
    public ResponseEntity<Worker> create(@RequestBody @Valid WorkerCreateDto createDto) {
        Worker categoryResponseDto = service.save(createDto);
        return ResponseEntity.ok(categoryResponseDto);
    }


    @GetMapping
    public ResponseEntity<Page<WorkerResponseDto>> getAll(Pageable pageable, @RequestParam(required = false) String predicate) {
        Page<WorkerResponseDto> all = service.getAll(pageable, predicate);
        return ResponseEntity.ok(all);
    }


    @GetMapping("/{id}")
    public ResponseEntity<WorkerResponseDto> get(@PathVariable Long id) {
        WorkerResponseDto responseDto = service.getById(id);
        return ResponseEntity.ok(responseDto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<WorkerResponseDto> update(@PathVariable Long id, @RequestBody @Valid WorkerUpdateDto updateDto) {
        WorkerResponseDto responseDto = service.update(id, updateDto);
        return ResponseEntity.ok(responseDto);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<WorkerResponseDto> patch(@PathVariable Long id, @RequestBody WorkerPatchDto patchDto) throws NoSuchFieldException, IllegalAccessException {
        WorkerResponseDto responseDto = service.patch(id, patchDto);
        return ResponseEntity.ok(responseDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
