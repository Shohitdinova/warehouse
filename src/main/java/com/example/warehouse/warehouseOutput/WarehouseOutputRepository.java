package com.example.warehouse.warehouseOutput;

import com.example.warehouse.common.repository.GenericSpecificationRepository;
import com.example.warehouse.warehouseOutput.entity.WarehouseOutput;
import com.example.warehouse.warehouseOutputItem.entity.WarehouseOutputItem;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WarehouseOutputRepository extends GenericSpecificationRepository<WarehouseOutput,Long> {
    List<WarehouseOutputItem> findByDate(LocalDate date);

}
