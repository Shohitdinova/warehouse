package com.example.warehouse.warehouseCost;

import com.example.warehouse.warehouseCost.dto.CostDto;
import com.example.warehouse.warehouseCost.dto.WarehouseCostCreateDto;
import com.example.warehouse.warehouseCost.entity.WarehouseCost;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warehouseCost")
@RequiredArgsConstructor
public class WarehouseCostController {

    @Autowired
    private WarehouseCostService service;

    @PostMapping("/omborgaKirim")
    public ResponseEntity<WarehouseCost> create(@RequestBody @Valid WarehouseCostCreateDto createDto) {
        WarehouseCost warehouseCostResponseDto = service.saveCostWithItems(createDto);
        return ResponseEntity.ok(warehouseCostResponseDto);
    }



    @GetMapping("/{id}")
    public ResponseEntity<CostDto> getById(@PathVariable Long id) {
        CostDto warehouseCostDto = service.getWarehouseCostDtoById(id);

        if (warehouseCostDto != null) {
            return new ResponseEntity<>(warehouseCostDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



//
//  @GetMapping("/{cost}")
//    public ResponseEntity<CostDto> getByCost(@PathVariable String cost) {
//        CostDto warehouseCostDto = service.getWarehouseCostDtoByCost(cost);
//
//        if (warehouseCostDto != null) {
//            return new ResponseEntity<>(warehouseCostDto, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }



























}
