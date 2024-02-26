package com.example.warehouse.warehouseCost;

import com.example.warehouse.common.exception.CustomException;
import com.example.warehouse.common.service.GenericCrudService;
import com.example.warehouse.currancyType.CurrancyTypeRepository;
import com.example.warehouse.currancyType.entity.CurrencyType;
import com.example.warehouse.product.ProducteRepository;
import com.example.warehouse.taminotchi.TaminotchiRepository;
import com.example.warehouse.taminotchi.entity.Taminotchi;
import com.example.warehouse.warehouse.WarehouseRepository;
import com.example.warehouse.warehouse.entity.Warehouse;
import com.example.warehouse.warehouseCost.dto.WarehouseCostCreateDto;
import com.example.warehouse.warehouseCost.dto.WarehouseCostPatchDto;
import com.example.warehouse.warehouseCost.dto.WarehouseCostResponseDto;
import com.example.warehouse.warehouseCost.dto.WarehouseCostUpdateDto;
import com.example.warehouse.warehouseCost.entity.WarehouseCost;
import com.example.warehouse.warehouseCostItem.WarehouseCostItemRepository;
import com.example.warehouse.warehouseCostItem.WarehouseCostItemService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service
@Getter
@RequiredArgsConstructor
public class WarehouseCostService extends GenericCrudService<WarehouseCost, Long, WarehouseCostCreateDto, WarehouseCostUpdateDto, WarehouseCostPatchDto, WarehouseCostResponseDto> {

    private final Class<WarehouseCost> entityClass = WarehouseCost.class;
    private final WarehouseCostDtoMapper mapper;
    private final WarehouseRepository warehouseRepository;
    private final ProducteRepository producteRepository;
    private final WarehouseCostRepository repository;
    private final WarehouseCostItemRepository warehouseCostItemRepository;
    private final TaminotchiRepository taminotchiRepository;
    private final CurrancyTypeRepository currancyTypeRepository;
    private final WarehouseCostItemService costItemService;


    public WarehouseCost saveCostWithItems(WarehouseCostCreateDto cost) {
        WarehouseCost savedCost = save(cost);
        costItemService.save(cost);
        return savedCost;
    }


    @Override
    protected WarehouseCost save(WarehouseCostCreateDto warehouseCostCreateDto) {
        WarehouseCost warehouseCost = new WarehouseCost();
        warehouseCost.setDate(warehouseCostCreateDto.getDate());

        Warehouse warehouse = warehouseRepository.getByIdAndStatusTrue(warehouseCostCreateDto.getWarehouseId())
                .orElseThrow(() -> new CustomException("warehouse not fount"));
        warehouseCost.setWarehouse(warehouse);

        Taminotchi taminotchi = taminotchiRepository.findById(warehouseCostCreateDto.getTaminotchiId())
                .orElseThrow(() -> new CustomException("taminotchi not fount"));
        warehouseCost.setTaminotchi(taminotchi);

        CurrencyType currencyType = currancyTypeRepository.findById(warehouseCostCreateDto.getCurrencyTypeId())
                .orElseThrow(() -> new CustomException("currency Type not fount"));
        warehouseCost.setCurrancyType(currencyType);

        warehouseCost.setInvoiceNumber("Generated Invoice Number: " + generateInvoiceNumber());
        warehouseCost.setCostCode(warehouseCostCreateDto.getCostCode());

        return repository.save(warehouseCost);
    }


    @Override
    protected WarehouseCost updateEntity(WarehouseCostUpdateDto updateDto, WarehouseCost warehouseCost) {
        mapper.update(updateDto, warehouseCost);
        return repository.save(warehouseCost);
    }


    public static String generateInvoiceNumber() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("Mdd");
        String currentDate = dateFormat.format(new Date());
        int randomPart = new Random().nextInt(900) + 100;
        return currentDate + randomPart;
    }

}

