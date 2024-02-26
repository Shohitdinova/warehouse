package com.example.warehouse.warehouse;

import com.example.warehouse.common.repository.GenericSpecificationRepository;
import com.example.warehouse.warehouse.entity.Warehouse;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WarehouseRepository extends GenericSpecificationRepository<Warehouse, Long> {
    Optional<Warehouse> getByIdAndStatusTrue(Long id);

    // List<Warehouse> findByStatusTrue(Warehouse warehouse);
}
