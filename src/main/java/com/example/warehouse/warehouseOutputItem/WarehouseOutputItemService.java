package com.example.warehouse.warehouseOutputItem;

import com.example.warehouse.common.exception.CustomException;
import com.example.warehouse.common.service.GenericCrudService;
import com.example.warehouse.product.ProducteRepository;
import com.example.warehouse.product.entity.Product;
import com.example.warehouse.warehouseOutput.WarehouseOutputRepository;
import com.example.warehouse.warehouseOutput.dto.WarehouseOutputCreateDto;
import com.example.warehouse.warehouseOutput.entity.WarehouseOutput;
import com.example.warehouse.warehouseOutputItem.dto.WarehouseOutputItemCreateDto;
import com.example.warehouse.warehouseOutputItem.dto.WarehouseOutputItemResponseDto;
import com.example.warehouse.warehouseOutputItem.entity.WarehouseOutputItem;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
public class WarehouseOutputItemService extends GenericCrudService<WarehouseOutputItem, Long, WarehouseOutputItemCreateDto, WarehouseOutputItem, WarehouseOutputItem, WarehouseOutputItemResponseDto> {

    private final WarehouseOutItemRepository repository;
    private final WarehouseOutputItemDtoMapper mapper;
    private final Class<WarehouseOutputItem> entityClass = WarehouseOutputItem.class;
    private final ModelMapper modelMapper;
    private final WarehouseOutputRepository outRepository;
    private final ProducteRepository producteRepository;
    private final WarehouseOutputRepository warehouseOutputRepository;


//    public WarehouseOutputItem save1(WarehouseOutputCreateDto createDto) {
//
//        WarehouseOutputItem warehouseOutputItem = new WarehouseOutputItem();
//
//        for (WarehouseOutputItemCreateDto outputItem : createDto.getWarehouseOutputItemList()) {
//
//            if (outputItem.getCount() < 1) {
//                throw new CustomException("It cannot be so");
//            } else {
//                warehouseOutputItem.setCount(outputItem.getCount());
//            }
//            if (outputItem.getProduct_price() < 1) {
//                throw new CustomException("It cannot be so");
//            } else {
//                warehouseOutputItem.setProduct_price(outputItem.getProduct_price());
//            }
//            warehouseOutputItem.setCount(outputItem.getCount());
//            warehouseOutputItem.setProduct_price(outputItem.getProduct_price());
//            Product product = producteRepository.findById(outputItem.getProduct())
//                    .orElseThrow(() -> new CustomException("product not fount"));
//
//            warehouseOutputItem.setProduct(product);
//
//            return repository.save(warehouseOutputItem);
//        }
//        return repository.save(warehouseOutputItem);
//    }



    public List<WarehouseOutputItem> saveWarehouseOutputItems(WarehouseOutputCreateDto itemsDto, WarehouseOutput warehouseOutput) {

        List<WarehouseOutputItem> savedItems = new ArrayList<>();
        for (WarehouseOutputItemCreateDto itemDto : itemsDto.getWarehouseOutputItemList()) {
            WarehouseOutputItem warehouseOutputItem = new WarehouseOutputItem();
            warehouseOutputItem.setProduct(producteRepository.findById(itemDto.getProduct())
                    .orElseThrow(() -> new CustomException("Product not found")));
            warehouseOutputItem.setCount(itemDto.getCount());
            warehouseOutputItem.setProduct_price(itemDto.getProduct_price());
            warehouseOutputItem.setWarehouseOutput(warehouseOutput);
            savedItems.add(repository.save(warehouseOutputItem));

        }

        return savedItems;
    }




    @Override
    protected WarehouseOutputItem save(WarehouseOutputItemCreateDto warehouseOutputItem) {

        WarehouseOutputItem warehouseOutputItem1 = new WarehouseOutputItem();
        warehouseOutputItem1.setCount(warehouseOutputItem.getCount());
        warehouseOutputItem1.setProduct_price(warehouseOutputItem.getProduct_price());
        warehouseOutputItem1.setCount(warehouseOutputItem.getCount());

        Product product = producteRepository.findById(warehouseOutputItem.getProduct())
                .orElseThrow(() -> new RuntimeException("Product not found"));
       warehouseOutputItem1.setProduct(product);
        return repository.save(warehouseOutputItem1);
    }




    public List<?> getDailyProductCounts() {
        return repository.getDailyProductCounts();
    }
    @Override
    protected WarehouseOutputItem updateEntity(WarehouseOutputItem warehouseOutputItem, WarehouseOutputItem warehouseOutputItem2) {
        mapper.update(warehouseOutputItem, warehouseOutputItem2);
        return repository.save(warehouseOutputItem);

    }

//    //Kunlik eng ko’p chiqim qilingan mahsulotlar
//    public List<Product> getTopSellingProductsForDayOut(LocalDate date) {
//        List<WarehouseOutputItem> byDate = outRepository.findByDate(date);
//
//        return calculateTopSellingProductsCost(byDate);
//    }
//
//
//    public List<Product> calculateTopSellingProductsCost(List<WarehouseOutputItem> outputItems) {
//        Map<Product, Double> productQuantityMap = outputItems.stream()
//                .collect(Collectors.groupingBy(WarehouseOutputItem::getProduct,
//                        Collectors.summingDouble(WarehouseOutputItem::getCount)));
//
//        return productQuantityMap.entrySet().stream()
//                .sorted(Map.Entry.<Product, Double>comparingByValue().reversed())
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toList());
//    }

}
