package com.example.test.service;

import com.example.test.dto.request.ClientRequestDto;
import com.example.test.dto.response.ClientResponseDto;
import com.example.test.mapper.ClientMapperService;
import com.example.test.repository.ClientRepository;
import com.example.test.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClientService implements CrudService<ClientRequestDto, ClientResponseDto> {

    private final ClientRepository clientRepository;
    private final ClientMapperService clientMapperService;

    public ClientService(ClientRepository clientRepository, ClientMapperService clientMapperService) {
        this.clientRepository = clientRepository;
        this.clientMapperService = clientMapperService;
    }

    @Override
    public ClientResponseDto create(ClientRequestDto clientRequestDto) {
        Client client = clientMapperService.convertToEntity(clientRequestDto);
        Client savedClient = clientRepository.save(client);
        return clientMapperService.convertToDto(savedClient);
    }

    @Override
    public ClientResponseDto update(Long id, ClientRequestDto clientRequestDto) {
        Client existingClient = clientRepository.findById(id).orElse(null);
        if (existingClient != null) {
            existingClient.setName(clientRequestDto.getName());
            existingClient.setSurname(clientRequestDto.getSurname());
            existingClient.setEmail(clientRequestDto.getEmail());
            existingClient.setPhone(clientRequestDto.getPhone());
            existingClient.setAddress(clientRequestDto.getAddress());
            existingClient.setGenre(clientRequestDto.getGenre());
            existingClient.setInitialPhysicalStatus(clientRequestDto.getInitialPhysicalStatus());
            existingClient.setAsignedGym(clientRequestDto.getAsignedGym());
        }
        Client updatedClient = clientRepository.save(Objects.requireNonNull(existingClient));
        return clientMapperService.convertToDto(updatedClient);
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public ClientResponseDto findById(Long id) {
        Client foundedClient = clientRepository.findById(id).orElse(null);
        return clientMapperService.convertToDto(foundedClient);
    }

    @Override
    public List<ClientResponseDto> findAll() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(clientMapperService::convertToDto)
                .toList();
    }
}
