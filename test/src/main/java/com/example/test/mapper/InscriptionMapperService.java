package com.example.test.mapper;

import com.example.test.dto.request.InscriptionRequestDto;
import com.example.test.dto.response.InscriptionResponseDto;
import com.example.test.model.Inscription;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class InscriptionMapperService {


    private final ModelMapper modelMapper;

    public InscriptionMapperService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public InscriptionResponseDto convertToDto(Inscription inscription) {
        return modelMapper.map(inscription, InscriptionResponseDto.class);
    }

    public Inscription convertToEntity(InscriptionRequestDto inscriptionRequestDto) {
        return modelMapper.map(inscriptionRequestDto, Inscription.class);
    }
}
