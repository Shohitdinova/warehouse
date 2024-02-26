package com.example.warehouse.worker;

import com.example.warehouse.common.repository.GenericSpecificationRepository;
import com.example.warehouse.worker.entity.Worker;
import org.springframework.stereotype.Repository;


@Repository
public interface WorkerRepository extends GenericSpecificationRepository<Worker, Long> {

}
