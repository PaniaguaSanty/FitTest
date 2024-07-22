package com.example.test.service;

import com.example.test.dto.request.ClientRequestDto;
import com.example.test.dto.request.InscriptionRequestDto;
import com.example.test.dto.response.InscriptionResponseDto;
import com.example.test.mapper.ClientMapperService;
import com.example.test.mapper.GManagerMapperService;
import com.example.test.mapper.InscriptionMapperService;
import com.example.test.model.Client;
import com.example.test.model.GymManager;
import com.example.test.model.Inscription;
import com.example.test.repository.ClientRepository;
import com.example.test.repository.InscriptionRepository;
import com.example.test.repository.ManagerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InscriptionService {

    private final InscriptionRepository inscriptionRepository;
    private final ClientRepository clientRepository;
    private final ManagerRepository managerRepository;
    private final InscriptionMapperService inscriptionMapperService;
    private final GManagerMapperService managerMapperService;
    private final ClientMapperService clientMapperService;

    public InscriptionService(InscriptionRepository inscriptionRepository,
                              ClientRepository clientRepository,
                              ManagerRepository managerRepository,
                              InscriptionMapperService inscriptionMapperService,
                              GManagerMapperService managerMapperService,
                              ClientMapperService clientMapperService) {

        this.inscriptionRepository = inscriptionRepository;
        this.clientRepository = clientRepository;
        this.managerRepository = managerRepository;
        this.inscriptionMapperService = inscriptionMapperService;
        this.managerMapperService = managerMapperService;
        this.clientMapperService = clientMapperService;

    }

    public InscriptionResponseDto create(InscriptionRequestDto inscriptionRequestDto, ClientRequestDto clientRequestDto, String managerDni) {
        //Se realiza la conversión de dto a entidadad

        Inscription newInscription = inscriptionMapperService.convertToEntity(inscriptionRequestDto);
        Client asignedClient = clientMapperService.convertToEntity(clientRequestDto);

        //Se realiza la búsqueda del manager por dni
        GymManager asignedManager = managerRepository.findByDni(managerDni)
                .orElseThrow(() -> new IllegalArgumentException("Manager not found with DNI: " + managerDni));


        //Se crea la inscripción
        newInscription.setInscriptionDate(LocalDate.now());
        newInscription.setClient(asignedClient);
        newInscription.setGymManager(asignedManager);
        newInscription.setGym(null);

        //Se crea y guarda al cliente.
        Client newClient = clientRepository.save(asignedClient);

        //se crea, guarda y muestra la inscripción.
        Inscription savedInscription = inscriptionRepository.save(newInscription);
        return inscriptionMapperService.convertToDto(savedInscription);
    }


    public InscriptionResponseDto update(Long id, InscriptionRequestDto inscriptionRequestDto) {
        return null;
    }


    public void delete(Long id) {

    }


    public InscriptionResponseDto findById(Long id) {
        return null;
    }


    public List<InscriptionResponseDto> findAll() {
        return List.of();
    }
}
