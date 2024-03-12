package com.example.warehouse.warehouseOutputItem.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DailyProductCountDTO {

    private String productName;
    private Long dailyCount;

    public DailyProductCountDTO(String productName, Long dailyCount) {
        this.productName = productName;
        this.dailyCount = dailyCount;
    }

}
