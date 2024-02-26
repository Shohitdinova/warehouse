package com.example.warehouse.worker;

import com.example.warehouse.common.exception.CustomException;
import com.example.warehouse.common.service.GenericCrudService;
import com.example.warehouse.warehouse.WarehouseRepository;
import com.example.warehouse.warehouse.entity.Warehouse;
import com.example.warehouse.worker.dto.WorkerCreateDto;
import com.example.warehouse.worker.dto.WorkerPatchDto;
import com.example.warehouse.worker.dto.WorkerResponseDto;
import com.example.warehouse.worker.dto.WorkerUpdateDto;
import com.example.warehouse.worker.entity.Worker;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@Getter
@RequiredArgsConstructor
public class WorkerService extends GenericCrudService<Worker, Long, WorkerCreateDto, WorkerUpdateDto, WorkerPatchDto, WorkerResponseDto> {

    private final WorkerRepository repository;
    private final WorkerDtoMapper mapper;
    private final Class<Worker> entityClass = Worker.class;
    private final ModelMapper modelMapper;
    private final WarehouseRepository warehouseRepository;


@Override
    public Worker save(WorkerCreateDto workerDto) {
        Worker worker = new Worker();
        worker.setName(workerDto.getName());
        worker.setSurname(workerDto.getSurname());
        worker.setUserName(workerDto.getUserName());
        worker.setPassword(workerDto.getPassword());
        worker.setPhoneNumber(workerDto.getPhoneNumber());

    Warehouse warehouse = warehouseRepository.getByIdAndStatusTrue(workerDto.getWarehouse_id())
            .orElseThrow(() -> new CustomException("Warehouse not found"));

    worker.setWarehouse(warehouse);

        return repository.save(worker);

}



    @Override
    protected Worker updateEntity(WorkerUpdateDto updateDto, Worker worker) {
        mapper.update(updateDto, worker);
        return repository.save(worker);
    }


}

