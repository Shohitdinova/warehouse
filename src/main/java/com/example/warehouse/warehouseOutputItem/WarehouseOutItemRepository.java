package com.example.warehouse.warehouseOutputItem;

import com.example.warehouse.common.repository.GenericSpecificationRepository;
import com.example.warehouse.warehouseOutputItem.entity.WarehouseOutputItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WarehouseOutItemRepository extends GenericSpecificationRepository<WarehouseOutputItem, Long> {

//    @Query(nativeQuery = true, value =
//            "SELECT p.name AS product_name, SUM(c.count) AS total_count\n" +
//                    "FROM warehouse_output_item c\n" +
//                    "JOIN product p ON c.product_id = p.id\n" +
//                    "WHERE DATE(c.created_at) = CURRENT_DATE\n" +
//                    "GROUP BY p.name\n" +
//                    "ORDER BY total_count DESC;")
//    List<DailyProductCountDTO> getDailyProductCounts();


//    @Query(nativeQuery = true, value =
//            "SELECT p.name AS product_name, SUM(c.count) AS total_count " +
//                    "FROM chiqim c " +
//                    "JOIN product p ON c.product_id = p.id " +
//                    "WHERE DATE(c.created_at) = CURRENT_DATE " +
//                    "GROUP BY p.name " +
//                    "ORDER BY total_count DESC")
//@Query(value = "SELECT SUM(count) as total FROM warehouse_cost_item w WHERE expiry_date >= CURRENT_DATE \n", nativeQuery = true)

    @Query(value = "SELECT MAX(count) as max_count FROM warehouse_cost_item WHERE expiry_date < CURRENT_DATE", nativeQuery = true)
    List<Double> getDailyProductCounts();


}


