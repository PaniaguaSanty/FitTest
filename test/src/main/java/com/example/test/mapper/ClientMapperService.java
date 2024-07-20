package com.example.test.mapper;



import com.example.test.dto.request.ClientRequestDto;
import com.example.test.dto.response.ClientResponseDto;
import com.example.test.model.Client;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ClientMapperService {

    private final ModelMapper modelMapper;

    public ClientMapperService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ClientResponseDto convertToDto(Client client) {
        return modelMapper.map(client, ClientResponseDto.class);
    }

    public Client convertToEntity(ClientRequestDto clientRequestDto) {
        return modelMapper.map(clientRequestDto, Client.class);
    }
}

