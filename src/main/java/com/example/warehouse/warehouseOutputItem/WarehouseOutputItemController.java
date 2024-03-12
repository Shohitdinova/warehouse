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

import java.util.List;

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

    @GetMapping("/daily-product-counts")
    public List<?> getDailyProductCounts() {
        return warehouseOutputItemService.getDailyProductCounts();
    }


//
//    @GetMapping("top-selling")
//    public List<Product> getTopSellingProductsForDayOut1(@RequestParam ("date")  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
//        List<Product> topSellingProductsForDayOut = warehouseOutputItemService.getTopSellingProductsForDayOut(date);
//        return ResponseEntity.ok(topSellingProductsForDayOut).getBody();
//    }



//    @GetMapping("/top-selling-products")
//    public List<Product> getTopSellingProductsForDayOut(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
//        List<WarehouseOutputItem> outputItemsForDay = getWarehouseOutputItemsForDay(date);
//        return calculateTopSellingProductsCost(outputItemsForDay);
//    }
}
