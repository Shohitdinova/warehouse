package com.example.warehouse.product;

import com.example.warehouse.categoty.CategoryRepository;
import com.example.warehouse.categoty.entity.Category;
import com.example.warehouse.common.exception.CustomException;
import com.example.warehouse.common.service.GenericCrudService;
import com.example.warehouse.product.dto.ProductCreateDto;
import com.example.warehouse.product.dto.ProductPatchDto;
import com.example.warehouse.product.dto.ProductResponseDto;
import com.example.warehouse.product.dto.ProductUpdateDto;
import com.example.warehouse.product.entity.Product;
import com.example.warehouse.unit.UnitRepository;
import com.example.warehouse.unit.entity.Unit;
import com.example.warehouse.warehouseCost.WarehouseCostRepository;
import com.example.warehouse.warehouseCost.WarehouseCostService;
import com.example.warehouse.warehouseCostItem.WarehouseCostItemRepository;
import com.example.warehouse.warehouseCostItem.WarehouseCostItemService;
import com.example.warehouse.warehouseCostItem.entity.WarehouseCostItem;
import com.example.warehouse.warehouseOutput.WarehouseOutputService;
import com.example.warehouse.warehouseOutputItem.WarehouseOutItemRepository;
import com.example.warehouse.warehouseOutputItem.WarehouseOutputItemService;
import com.example.warehouse.warehouseOutputItem.entity.WarehouseOutputItem;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@Service
@Getter
@RequiredArgsConstructor
public class ProductService extends GenericCrudService<Product, Long, ProductCreateDto, ProductUpdateDto, ProductPatchDto, ProductResponseDto> {

    private final ProducteRepository repository;
    private final ProductDtoMapper mapper;
    private final Class<Product> entityClass = Product.class;
    private final ModelMapper modelMapper;
    private final WarehouseOutItemRepository warehouseOutProductRepository;
    private final WarehouseCostItemRepository warehouseCostItemRepository;
    private final WarehouseCostRepository warehouseCostRepository;
    private final WarehouseOutputItemService warehouseOutputItemService;
    private final WarehouseCostItemService warehouseCostItemService;
    private final WarehouseOutputService outputService;
    private final WarehouseCostService costService;
    private final UnitRepository unitRepository;
    private final CategoryRepository categoryRepository;

    static List<WarehouseCostItem> warehouseCostItems;


    @Override
    protected Product save(ProductCreateDto createDto) {
        Product product = new Product();
        product.setName(createDto.getName());
       // product.setPicture(createDto.getPicture());
        product.setProductNumber(createDto.getProductNumber());
        product.setAccountingCode(createDto.getAccountingCode());

        Unit unit = unitRepository.findById(createDto.getUnit_id())
                .orElseThrow(() ->new CustomException("UNIT not found"));
        product.setUnit(unit);

         Category category = categoryRepository.findById(createDto.getCategory_id())
                .orElseThrow(() -> new CustomException("CATEGORY not found"));
        product.setCategory(category);

        return repository.save(product);
    }





    @Override
    protected Product updateEntity(ProductUpdateDto updateDto, Product product) {
        mapper.update(updateDto, product);
        return repository.save(product);
    }








    // Yaroqlilik muddati yetib qolgan mahsulotlar soni
    public int Product_ExpiryDate() {
        int soni = 0;
        LocalDate date = LocalDate.now();
        for (WarehouseCostItem product : warehouseCostItems) {
            if (product.getExpiryDate().isAfter(date)) {
                soni++;
            }
        }
        return soni;
    }


    // Kunlik eng ko'p chiqim qilingan mahsulotlar
    public List<Product> getDailyOutProducts(LocalDate sana) {
        List<WarehouseOutputItem> all = warehouseOutProductRepository.findAll();

        Map<Product, Integer> countProduct = new HashMap<>();
        for (WarehouseOutputItem chiqim : all) {
            Product mahsulot = chiqim.getProduct();
            int soni = (int) chiqim.getCount();
            countProduct.put(mahsulot, countProduct.getOrDefault(mahsulot, 0) + soni);
        }
        List<Product> maxProduct = new ArrayList<>(countProduct.keySet());
        maxProduct.sort(Comparator.comparingInt(countProduct::get).reversed());

        return maxProduct;
    }


    //Kunlik eng ko’p chiqim qilingan mahsulotlar
    public List<Product> getTopSellingProductsForDayOut(LocalDate date) {
        List<WarehouseOutputItem> outputItemsForDay = warehouseOutputItemService.getWarehouseOutputItemsForDay(date);
        return calculateTopSellingProductsOut(outputItemsForDay);
    }

    private List<Product> calculateTopSellingProductsOut(List<WarehouseOutputItem> outputItems) {
        Map<Product, Double> productQuantityMap = outputItems.stream()
                .collect(Collectors.groupingBy(WarehouseOutputItem::getProduct,
                        Collectors.summingDouble(WarehouseOutputItem::getCount)));

        return productQuantityMap.entrySet().stream()
                .sorted(Map.Entry.<Product, Double>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


    //Kunlik eng ko’p krim qilingan mahsulotlar
    public List<Product> getTopSellingProductsForDayCost(LocalDate date) {
        List<WarehouseCostItem> costsForDay = warehouseCostItemService.getWarehouseCostItemsForDay(date);
        return calculateTopSellingProductsCost(costsForDay);
    }

    private List<Product> calculateTopSellingProductsCost(List<WarehouseCostItem> costItems) {
        Map<Product, Double> productQuantityMap = costItems.stream()
                .collect(Collectors.groupingBy(WarehouseCostItem::getProduct_id,
                        Collectors.summingDouble(WarehouseCostItem::getCount)));

        return productQuantityMap.entrySet().stream()
                .sorted(Map.Entry.<Product, Double>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


}



