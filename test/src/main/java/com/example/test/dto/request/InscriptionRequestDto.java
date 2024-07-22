package com.example.test.dto.request;

import com.example.test.model.Client;
import com.example.test.model.Gym;
import com.example.test.model.GymManager;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InscriptionRequestDto {

    private LocalDate inscriptionDate;
    private GymManager gymManager;
    private Client client;
    private Gym gym;

}
