package com.example.warehouse.warehouseOutputItem;

import com.example.warehouse.common.repository.GenericSpecificationRepository;
import com.example.warehouse.warehouseOutputItem.entity.WarehouseOutputItem;
import org.springframework.stereotype.Repository;


@Repository
public interface WarehouseOutItemRepository extends GenericSpecificationRepository<WarehouseOutputItem, Long> {
}


