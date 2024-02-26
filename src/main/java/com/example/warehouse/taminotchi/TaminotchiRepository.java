package com.example.warehouse.taminotchi;

import com.example.warehouse.common.repository.GenericSpecificationRepository;
import com.example.warehouse.taminotchi.entity.Taminotchi;
import org.springframework.stereotype.Repository;


@Repository
public interface TaminotchiRepository extends GenericSpecificationRepository<Taminotchi, Long> {

}
