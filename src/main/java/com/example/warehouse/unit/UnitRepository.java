package com.example.warehouse.unit;

import com.example.warehouse.common.repository.GenericSpecificationRepository;
import com.example.warehouse.unit.entity.Unit;
import org.springframework.stereotype.Repository;


@Repository
public interface UnitRepository extends GenericSpecificationRepository<Unit, Long> {

}
