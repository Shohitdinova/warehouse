package com.example.warehouse.warehouseOutputItem;

import com.example.warehouse.common.exception.CustomException;
import com.example.warehouse.common.service.GenericCrudService;
import com.example.warehouse.product.ProducteRepository;
import com.example.warehouse.product.entity.Product;
import com.example.warehouse.warehouseOutput.WarehouseOutputRepository;
import com.example.warehouse.warehouseOutput.dto.WarehouseOutputCreateDto;
import com.example.warehouse.warehouseOutputItem.dto.WarehouseOutputItemCreateDto;
import com.example.warehouse.warehouseOutputItem.dto.WarehouseOutputItemResponseDto;
import com.example.warehouse.warehouseOutputItem.entity.WarehouseOutputItem;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
public class WarehouseOutputItemService extends GenericCrudService<WarehouseOutputItem,Long,WarehouseOutputItem,WarehouseOutputItem,WarehouseOutputItem, WarehouseOutputItemResponseDto> {

    private final WarehouseOutItemRepository repository;
    private final WarehouseOutputItemDtoMapper mapper;
    private final Class<WarehouseOutputItem> entityClass = WarehouseOutputItem.class;
    private final ModelMapper modelMapper;
    private final WarehouseOutputRepository outRepository;
    private final ProducteRepository producteRepository;





    public WarehouseOutputItem save(WarehouseOutputCreateDto createDto) {

        WarehouseOutputItem warehouseOutputItem = new WarehouseOutputItem();

        for (WarehouseOutputItemCreateDto outputItem : createDto.getWarehouseOutputItemList()) {

            if (outputItem.getCount() < 1) {
                throw new CustomException("It cannot be so");
            } else {
                warehouseOutputItem.setCount(outputItem.getCount());
            }
            if (outputItem.getProduct_price() < 1) {
                throw new CustomException("It cannot be so");
            } else {
                warehouseOutputItem.setProduct_price(outputItem.getProduct_price());
            }



            warehouseOutputItem.setCount(outputItem.getCount());
            warehouseOutputItem.setProduct_price(outputItem.getProduct_price());
            Product product = producteRepository.findById(outputItem.getProduct())
                    .orElseThrow(() -> new CustomException("product not fount"));

            warehouseOutputItem.setProduct(product);

             return repository.save(warehouseOutputItem);
        }
        return  repository.save(warehouseOutputItem);
    }


    @Override
    protected WarehouseOutputItem save(WarehouseOutputItem warehouseOutputItem) {

        WarehouseOutputItem warehouseOutputItem1 = new WarehouseOutputItem();
        warehouseOutputItem1.setCount(warehouseOutputItem.getCount());
        warehouseOutputItem1.setProduct_price(warehouseOutputItem.getProduct_price());
        warehouseOutputItem1.setCount(warehouseOutputItem.getCount());

        Product product = producteRepository.findById(warehouseOutputItem.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        warehouseOutputItem1.setProduct(product);
        return repository.save(warehouseOutputItem1);
    }

    @Override
    protected WarehouseOutputItem updateEntity(WarehouseOutputItem warehouseOutputItem, WarehouseOutputItem warehouseOutputItem2) {
        mapper.update(warehouseOutputItem, warehouseOutputItem2);
        return repository.save(warehouseOutputItem);


    }
    public List<WarehouseOutputItem> getWarehouseOutputItemsForDay(LocalDate date) {
        return outRepository.findByDate(date);
    }



}
