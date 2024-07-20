package com.example.test.mapper;


import com.example.test.dto.request.TrainerRequestDto;
import com.example.test.dto.response.TrainerResponseDto;
import com.example.test.model.Trainer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TrainerMapperService {

    private final ModelMapper modelMapper;

    public TrainerMapperService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TrainerResponseDto convertToDto(Trainer trainer) {
        return modelMapper.map(trainer, TrainerResponseDto.class);
    }

    public Trainer convertToEntity(TrainerRequestDto trainerRequestDto) {
        return modelMapper.map(trainerRequestDto, Trainer.class);
    }
}

