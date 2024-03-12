package com.example.warehouse.warehouseOutput;
import com.example.warehouse.warehouseOutput.dto.OutputDto;
import com.example.warehouse.warehouseOutput.dto.WarehouseOutputCreateDto;
import com.example.warehouse.warehouseOutput.entity.WarehouseOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warehouse-output")
public class WarehouseOutputController {

    @Autowired
    private WarehouseOutputService warehouseOutputService;

    @GetMapping("/{id}")
    public ResponseEntity<OutputDto> getById(@PathVariable Long id) {
        OutputDto warehouseCostDto = warehouseOutputService.getWarehouseOutputDtoById(id);

        if (warehouseCostDto != null) {
            return new ResponseEntity<>(warehouseCostDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }





    @PostMapping("/create")
    public ResponseEntity<WarehouseOutput> createWarehouseOutput(@RequestBody WarehouseOutputCreateDto warehouseOutputDto) {

        WarehouseOutput createdWarehouseOutput = warehouseOutputService.saveCostWithItems(warehouseOutputDto);
        return new ResponseEntity<>(createdWarehouseOutput, HttpStatus.CREATED);

    }
}

