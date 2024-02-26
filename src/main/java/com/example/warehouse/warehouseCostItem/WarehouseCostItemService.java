package com.example.warehouse.warehouseCostItem;

import com.example.warehouse.common.exception.CustomException;
import com.example.warehouse.common.service.GenericCrudService;
import com.example.warehouse.product.ProducteRepository;
import com.example.warehouse.product.entity.Product;
import com.example.warehouse.warehouseCost.WarehouseCostRepository;
import com.example.warehouse.warehouseCost.dto.WarehouseCostCreateDto;
import com.example.warehouse.warehouseCostItem.dto.WarehouseCostItemCreateDto;
import com.example.warehouse.warehouseCostItem.dto.WarehouseCostItemResponseDto;
import com.example.warehouse.warehouseCostItem.entity.WarehouseCostItem;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
public class WarehouseCostItemService extends GenericCrudService<WarehouseCostItem, Long, WarehouseCostItemCreateDto, WarehouseCostItem, WarehouseCostItem, WarehouseCostItemResponseDto> {

    private final WarehouseCostItemRepository repository;
    private final WarehouseCostRepository costRepository;
    private final WarehouseCostItemDtoMapper mapper;
    private final Class<WarehouseCostItem> entityClass = WarehouseCostItem.class;
    private final ModelMapper modelMapper;
    private final ProducteRepository producteRepository;
    private final WarehouseCostRepository warehouseCostRepository;


    public WarehouseCostItem save(WarehouseCostCreateDto createDto) {
        WarehouseCostItem warehouseCostItem = new WarehouseCostItem();

        for (WarehouseCostItemCreateDto costItem : createDto.getWarehouseCostItems()) {
            if (costItem.getCount() < 1) {
                throw new CustomException("It cannot be so");
            } else {
                warehouseCostItem.setCount(costItem.getCount());
            }
            if (costItem.getPrice() < 1) {
                throw new CustomException("It cannot be so");
            } else {
                warehouseCostItem.setPrice(costItem.getPrice());
            }
            if (costItem.getExpiryDate().isBefore(LocalDate.now())){
                throw new CustomException("This product is not for sale");
            }else {
                warehouseCostItem.setExpiryDate(costItem.getExpiryDate());
            }


                warehouseCostItem.setPrice(costItem.getPrice());
            Product product = producteRepository.findById(costItem.getProductId())
                    .orElseThrow(() -> new CustomException("product not fount"));

            warehouseCostItem.setProduct_id(product);

            return repository.save(warehouseCostItem);
        }
        return repository.save(warehouseCostItem);

    }


    @Override
    protected WarehouseCostItem save(WarehouseCostItemCreateDto warehouseCostItemCreateDto) {
        return null;
    }

    @Override
    protected WarehouseCostItem updateEntity(WarehouseCostItem warehouseCostItem, WarehouseCostItem warehouseCostItem1) {
        mapper.update(warehouseCostItem, warehouseCostItem1);
        return repository.save(warehouseCostItem);
    }

    public List<WarehouseCostItem> getWarehouseCostItemsForDay(LocalDate date) {
        return costRepository.findByDate(date);
    }


}
