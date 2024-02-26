package com.example.warehouse.currancyType;

import com.example.warehouse.common.repository.GenericSpecificationRepository;
import com.example.warehouse.currancyType.entity.CurrencyType;
import org.springframework.stereotype.Repository;


@Repository
public interface CurrancyTypeRepository extends GenericSpecificationRepository<CurrencyType, Long> {

}
