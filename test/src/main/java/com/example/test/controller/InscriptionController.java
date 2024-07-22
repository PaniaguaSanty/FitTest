package com.example.test.controller;

import com.example.test.dto.request.InscriptionAndClientRequestDto;
import com.example.test.dto.response.InscriptionResponseDto;
import com.example.test.service.InscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inscriptions")
public class InscriptionController {
    private final InscriptionService inscriptionService;

    public InscriptionController(InscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    @PostMapping("/create")
    public ResponseEntity<InscriptionResponseDto> createInscription(
            @RequestBody InscriptionAndClientRequestDto request) {

        InscriptionResponseDto response = inscriptionService.create(
                request.getInscriptionRequestDto(),
                request.getClientRequestDto(),
                request.getManagerDni()
        );
        return ResponseEntity.ok(response);
    }
}

