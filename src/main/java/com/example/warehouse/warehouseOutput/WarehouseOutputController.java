package com.example.warehouse.warehouseOutput;
import com.example.warehouse.warehouseOutput.dto.WarehouseOutputCreateDto;
import com.example.warehouse.warehouseOutput.entity.WarehouseOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/warehouse-output")
public class WarehouseOutputController {

    @Autowired
    private WarehouseOutputService warehouseOutputService;

    @PostMapping("/create")
    public ResponseEntity<WarehouseOutput> createWarehouseOutput(@RequestBody WarehouseOutputCreateDto warehouseOutputDto) {

        WarehouseOutput createdWarehouseOutput = warehouseOutputService.saveCostWithItems(warehouseOutputDto);
        return new ResponseEntity<>(createdWarehouseOutput, HttpStatus.CREATED);

    }
}

