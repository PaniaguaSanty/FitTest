package com.example.test.dto.request;

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
public class GymManagerRequestDto {

    private String name;
    private String surname;
    private String dni;
    private String email;
    private String phone;
    private String address;
    private Date hireDate;
    private Gym gym;

}
