package com.example.warehouse.warehouseOutputItem;
import com.example.warehouse.warehouseOutputItem.dto.WarehouseOutputItemResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/warehouseOutputItem")
@RequiredArgsConstructor
public class WarehouseOutputItemController {


    private final WarehouseOutputItemService warehouseOutputItemService;
    @GetMapping
    public ResponseEntity<Page<WarehouseOutputItemResponseDto>> getAll(Pageable pageable, @RequestParam(required = false) String predicate) {
        Page<WarehouseOutputItemResponseDto> all = warehouseOutputItemService.getAll(pageable, predicate);
        return ResponseEntity.ok(all);
    }
}
