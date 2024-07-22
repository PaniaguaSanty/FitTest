package com.example.test.dto.response;

import com.example.test.model.Gym;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GymManagerResponseDto {

    private Long id;
    private String name;
    private String surname;
    private String dni;
    private String email;
    private String phone;
    private String address;
    private Date hireDate;
    private Gym gym;

}
