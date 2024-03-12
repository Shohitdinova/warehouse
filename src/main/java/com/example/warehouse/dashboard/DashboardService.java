package com.example.warehouse.dashboard;

import com.example.warehouse.warehouseCostItem.WarehouseCostItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class DashboardService {

    private WarehouseCostItemRepository productEntryRepository;

//    public List<WarehouseCostItemResponseDto> getDailyIncomingProducts() {
//        LocalDate today = LocalDate.now();
//        List<WarehouseCostItem> productEntries = productEntryRepository.findDailyProductEntries(today);
//
//        List<WarehouseCostItemResponseDto> result = new ArrayList<>();
//        for (WarehouseCostItem entry : productEntries) {
//            String productName = entry.getProduct_id().getName();
//            double price = entry.getPrice();
//            double count = entry.getCount();
//            double totalSum = price * count;
//
//            WarehouseCostItemResponseDto dto = new WarehouseCostItemResponseDto(productName, price, count, totalSum);
//            result.add(dto);
//        }
//
//        return result;
//    }
}
