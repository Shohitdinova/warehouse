package com.example.warehouse.worker;

import com.example.warehouse.common.service.GenericDtoMapper;
import com.example.warehouse.worker.dto.WorkerCreateDto;
import com.example.warehouse.worker.dto.WorkerResponseDto;
import com.example.warehouse.worker.dto.WorkerUpdateDto;
import com.example.warehouse.worker.entity.Worker;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WorkerDtoMapper extends GenericDtoMapper<Worker, WorkerCreateDto , WorkerUpdateDto, WorkerResponseDto> {

    private final ModelMapper mapper;

    @Override
    public Worker toEntity(WorkerCreateDto createDto) {
        return mapper.map(createDto, Worker.class);
    }

    @Override
    public WorkerResponseDto toResponseDto(Worker worker) {
        return mapper.map(worker, WorkerResponseDto.class);
    }

    @Override
    public void update(WorkerUpdateDto updateDto, Worker worker) {
        mapper.map(updateDto, worker);
    }

    @Override
    public WorkerCreateDto toCreateDto(Worker worker) {
        return mapper.map(worker, WorkerCreateDto.class);
    }
}
