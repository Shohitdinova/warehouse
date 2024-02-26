package com.example.warehouse.warehouseCost;

import com.example.warehouse.warehouseCost.dto.WarehouseCostCreateDto;
import com.example.warehouse.warehouseCost.entity.WarehouseCost;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/warehouseCost")
@RequiredArgsConstructor
public class WarehouseCostController {

    @Autowired
    private WarehouseCostService service;

    @PostMapping("/omborgaKirim")
    public ResponseEntity<WarehouseCost> create(@RequestBody @Valid WarehouseCostCreateDto createDto) {
      //  if (service != null) {
            WarehouseCost warehouseCostResponseDto = service.saveCostWithItems(createDto);
            return ResponseEntity.ok(warehouseCostResponseDto);
//        } else
//            return null;


    }


}
