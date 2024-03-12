package com.example.warehouse.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService productService;

//    @GetMapping("/daily-incoming")
//    public ResponseEntity<List<WarehouseCostItemResponseDto>> getDailyIncomingProducts(LocalDate date) {
//        List<WarehouseCostItemResponseDto> dailyIncomingProducts = productService.getDailyIncomingProducts();
//
//        if (dailyIncomingProducts != null && !dailyIncomingProducts.isEmpty()) {
//            return ResponseEntity.ok(dailyIncomingProducts);
//        } else {
//            return ResponseEntity.noContent().build();
//        }
//    }




}
