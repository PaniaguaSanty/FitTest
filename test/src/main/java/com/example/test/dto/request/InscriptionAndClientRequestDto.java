package com.example.test.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InscriptionAndClientRequestDto {

    private InscriptionRequestDto inscriptionRequestDto;
    private ClientRequestDto clientRequestDto;
    private String managerDni;

}
