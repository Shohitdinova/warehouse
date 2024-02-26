package com.example.warehouse.product;

import com.example.warehouse.common.repository.GenericSpecificationRepository;
import com.example.warehouse.product.entity.Product;
import org.springframework.stereotype.Repository;


@Repository
public interface ProducteRepository extends GenericSpecificationRepository<Product, Long> {

}
