package com.example.test.mapper;

import com.example.test.dto.request.GymManagerRequestDto;
import com.example.test.dto.response.GymManagerResponseDto;
import com.example.test.model.GymManager;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class GManagerMapperService {

    private final ModelMapper modelMapper;

    public GManagerMapperService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public GymManagerResponseDto convertToDto(GymManager gymManager) {
        return modelMapper.map(gymManager, GymManagerResponseDto.class);
    }

    public GymManager convertToEntity(GymManagerRequestDto gymManagerRequestDto) {
        return modelMapper.map(gymManagerRequestDto, GymManager.class);
    }
}
