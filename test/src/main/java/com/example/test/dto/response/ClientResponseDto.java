package com.example.test.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDto {

    private Long id;
    private String name;
    private String surname;
    private String dni;
    private String email;
    private String phone;
    private String address;
    private String genre;
    private String initialPhysicalStatus;
    private String asignedGym;
}
