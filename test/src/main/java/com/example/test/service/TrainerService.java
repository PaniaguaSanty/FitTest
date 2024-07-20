package com.example.test.service;

import com.example.test.dto.request.TrainerRequestDto;
import com.example.test.dto.response.TrainerResponseDto;
import com.example.test.mapper.TrainerMapperService;
import com.example.test.model.Trainer;
import com.example.test.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TrainerService implements CrudService<TrainerRequestDto, TrainerResponseDto> {


    private final TrainerRepository trainerRepository;
    private final TrainerMapperService trainerMapperService;

    public TrainerService(TrainerRepository trainerRepository, TrainerMapperService trainerMapperService) {
        this.trainerRepository = trainerRepository;
        this.trainerMapperService = trainerMapperService;
    }

    @Override
    public TrainerResponseDto create(TrainerRequestDto trainerRequestDto) {
        Trainer trainer = trainerMapperService.convertToEntity(trainerRequestDto);
        Trainer savedClient = trainerRepository.save(trainer);
        return trainerMapperService.convertToDto(savedClient);
    }

    @Override
    public TrainerResponseDto update(Long id, TrainerRequestDto trainerRequestDto) {
        Trainer existingTrainer = trainerRepository.findById(id).orElse(null);
        if (existingTrainer != null) {
            existingTrainer.setName(trainerRequestDto.getName());
            existingTrainer.setSurname(trainerRequestDto.getSurname());
            existingTrainer.setClassSchedules(trainerRequestDto.getClassSchedules());
            existingTrainer.setEmail(trainerRequestDto.getEmail());
            existingTrainer.setPhone(trainerRequestDto.getPhone());
            existingTrainer.setAddress(trainerRequestDto.getAddress());
            existingTrainer.setGym(trainerRequestDto.getGym());
            existingTrainer.setHireDate(trainerRequestDto.getHireDate());
        }
        Trainer updatedTrainer = trainerRepository.save(Objects.requireNonNull(existingTrainer));
        return trainerMapperService.convertToDto(updatedTrainer);
    }

    @Override
    public void delete(Long id) {
        trainerRepository.deleteById(id);
    }

    @Override
    public TrainerResponseDto findById(Long id) {
        Trainer foundedTrainer = trainerRepository.findById(id).orElse(null);
        return trainerMapperService.convertToDto(foundedTrainer);
    }

    @Override
    public List<TrainerResponseDto> findAll() {
        List<Trainer> trainers = trainerRepository.findAll();
        return trainers.stream()
                .map(trainerMapperService::convertToDto)
                .toList();
    }
}
