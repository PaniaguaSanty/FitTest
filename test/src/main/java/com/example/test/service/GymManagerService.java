package com.example.test.service;

import com.example.test.dto.request.GymManagerRequestDto;
import com.example.test.dto.response.GymManagerResponseDto;
import com.example.test.mapper.GManagerMapperService;
import com.example.test.model.GymManager;
import com.example.test.repository.ManagerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GymManagerService implements CrudService<GymManagerRequestDto, GymManagerResponseDto> {

    private final ManagerRepository managerRepository;
    private final GManagerMapperService gManagerMapperService;

    public GymManagerService(ManagerRepository managerRepository, GManagerMapperService gManagerMapperService) {
        this.managerRepository = managerRepository;
        this.gManagerMapperService = gManagerMapperService;
    }

    @Override
    public GymManagerResponseDto create(GymManagerRequestDto gymManagerRequestDto) {
        GymManager gymManager = gManagerMapperService.convertToEntity(gymManagerRequestDto);
        GymManager savedManager = managerRepository.save(gymManager);
        return gManagerMapperService.convertToDto(savedManager);
    }

    @Override
    public GymManagerResponseDto update(Long id, GymManagerRequestDto gymManagerRequestDto) {
        GymManager existingManager = managerRepository.findById(id).orElse(null);
        if (existingManager != null) {
            existingManager.setName(gymManagerRequestDto.getName());
            existingManager.setSurname(gymManagerRequestDto.getSurname());
            existingManager.setEmail(gymManagerRequestDto.getEmail());
            existingManager.setPhone(gymManagerRequestDto.getPhone());
            existingManager.setAddress(gymManagerRequestDto.getAddress());
            existingManager.setGym(gymManagerRequestDto.getGym());
            existingManager.setHireDate(gymManagerRequestDto.getHireDate());
        }
        GymManager updatedManager = managerRepository.save(Objects.requireNonNull(existingManager));
        return gManagerMapperService.convertToDto(updatedManager);
    }

    @Override
    public void delete(Long id) {
        managerRepository.deleteById(id);
    }

    @Override
    public GymManagerResponseDto findById(Long id) {
        GymManager foundedGymManager = managerRepository.findById(id).orElse(null);
        return gManagerMapperService.convertToDto(foundedGymManager);
    }

    @Override
    public List<GymManagerResponseDto> findAll() {
        List<GymManager> managers = managerRepository.findAll();
        return managers.stream()
                .map(gManagerMapperService::convertToDto)
                .toList();
    }
}

