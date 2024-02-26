package com.example.warehouse.categoty;

import com.example.warehouse.categoty.entity.Category;
import com.example.warehouse.common.repository.GenericSpecificationRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends GenericSpecificationRepository<Category, Long> {

}
